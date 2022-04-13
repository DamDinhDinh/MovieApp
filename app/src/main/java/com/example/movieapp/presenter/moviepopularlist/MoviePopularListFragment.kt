package com.example.movieapp.presenter.moviepopularlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapp.MyApplication
import com.example.movieapp.databinding.FragmentMoviePopularListBinding
import com.example.movieapp.presenter.adapter.MoviePopularAdapter
import com.example.movieapp.presenter.model.moviepopular.MoviePopular
import timber.log.Timber
import javax.inject.Inject

class MoviePopularListFragment : Fragment(), MoviePopularListContract.View {

    private val TAG = "MoviePopularListFragment"

    @Inject
    lateinit var vmFactory: MoviePopularListViewModel.Factory
    lateinit var viewModel: MoviePopularListContract.ViewModel

    private val binding: FragmentMoviePopularListBinding by viewBinding(CreateMethod.INFLATE)
    private val movieAdapter = MoviePopularAdapter { movie -> navigateMovieDetail(movie.id) }

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcMoviePopular.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        viewModel = ViewModelProvider(this, vmFactory)[MoviePopularListViewModel::class.java]
        viewModel.apply {
            fetchMoviePopular()
            observeViewState().observe(viewLifecycleOwner) { viewState -> updateViewState(viewState) }
        }
    }

    override fun updateViewState(viewState: MoviePopularListContract.ViewState) {
        Timber.d("$TAG updateViewState $viewState")
        renderMovieList(viewState.movieList)
    }

    private fun renderMovieList(movieList: List<MoviePopular>) {
        movieAdapter.submitList(movieList)
    }

    private fun navigateMovieDetail(id: Int) {
        val action =
            MoviePopularListFragmentDirections.actionMoviePopularListFragmentToMovieDetailFragment(
                id
            )
        findNavController().navigate(action)
    }
}