package com.example.movieapp.presenter.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.common.applySchedulers
import com.example.common.dataSchedulers
import com.example.data.local.mapper.movie.toModel
import com.example.data.local.roomdatabase.dao.MovieDao
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.moviepopular.toEntity
import com.example.domain.model.movie.ModelMovie
import com.example.movieapp.databinding.FragmentMoviePopularListBinding
import com.example.movieapp.presenter.adapter.MovieAdapter
import com.example.movieapp.presenter.mapper.movie.toPresent
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val TAG = "MoviePopularListFragment"

    @Inject
    lateinit var movieApi: MovieApi

    @Inject
    lateinit var movieDao: MovieDao
    private var getMoviePopularDisposable: Disposable? = null

    private val binding: FragmentMoviePopularListBinding by viewBinding(CreateMethod.INFLATE)
    private val movieAdapter = MovieAdapter { movie -> navigateMovieDetail(movie.id) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcMoviePopular.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        if ((binding.rcMoviePopular.adapter?.itemCount ?: 0) == 0) {
            fetchMoviePopular()
        }
    }

    private fun fetchMoviePopular() {
        getMoviePopularDisposable?.let { if (!it.isDisposed) it.dispose() }
        getMoviePopularDisposable =
            getPopular().applySchedulers()
                .map { list -> list.map { it.toPresent() } }
                .subscribe(
                    { list ->
                        movieAdapter.submitList(list)
                    }, { error -> error.printStackTrace() }
                )
    }

    private fun getPopular(): Observable<List<ModelMovie>> {
        fetchAndSavePopularMovie()
        return movieDao.getPopularMovie()
            .map { list -> list.map { it.toModel() } }
    }

    private fun fetchAndSavePopularMovie() {
        movieApi.getPopular()
            .dataSchedulers()
            .map { it.results?.map { movie -> movie.toEntity() } ?: listOf() }
            .subscribe({ list -> movieDao.insert(list) },
                { error -> error.printStackTrace()})
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()

        getMoviePopularDisposable?.let {
            if (!it.isDisposed) it.dispose()
        }
    }

    private fun navigateMovieDetail(id: Int) {
        val action =
            MovieListFragmentDirections.actionMoviePopularListFragmentToMovieDetailFragment(
                id
            )
        findNavController().navigate(action)
    }
}
