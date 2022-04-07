package com.example.movieapp.presenter.moviepopularlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.MyApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMoviePopularListBinding
import com.example.movieapp.presenter.model.moviepopular.MoviePopular
import javax.inject.Inject

class MoviePopularListFragment : Fragment(), MoviePopularListContract.View {

    private val TAG = "MoviePopularListFragment"

    @Inject
    lateinit var viewModel: MoviePopularListContract.ViewModel

    lateinit var binding: FragmentMoviePopularListBinding
    private val movieList = mutableListOf<MoviePopular>()
    private val movieAdapter = MoviePopularAdapter(movieList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (activity?.application as MyApplication).appComponent
        appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMoviePopularListBinding.inflate(inflater, container, false)

        activity?.title = resources.getString(R.string.movie_popular_screen)
        binding.rcMoviePopular.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        viewModel.observeViewState()
            .observe(viewLifecycleOwner) { viewState -> updateViewState(viewState) }
        return binding.root
    }

    private fun updateViewState(viewState: MoviePopularListContract.ViewState) {
        println("$TAG updateViewState $viewState")
        renderMovieList(viewState.movieList)
    }

    override fun renderMovieList(movieList: List<MoviePopular>) {
        this.movieList.apply {
            clear()
            addAll(movieList)
        }

        movieAdapter.notifyDataSetChanged()
    }

}