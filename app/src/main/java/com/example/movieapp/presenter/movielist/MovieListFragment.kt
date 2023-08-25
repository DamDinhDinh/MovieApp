package com.example.movieapp.presenter.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapp.databinding.FragmentMoviePopularListBinding
import com.example.movieapp.presenter.adapter.MovieAdapter
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val TAG = "MoviePopularListFragment"

    private val viewModel: MovieListViewModel by viewModels()

    private val binding: FragmentMoviePopularListBinding by viewBinding(CreateMethod.INFLATE)
    private val movieAdapter = MovieAdapter { movie -> navigateMovieDetail(movie.id) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcMoviePopular.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        viewModel.apply {
            observeViewState().observe(viewLifecycleOwner) { viewState -> updateViewState(viewState) }

            if (observeViewState().value == null) {
                fetchMoviePopular()
            }
        }
    }

    private fun updateViewState(viewState: MovieListViewModel.ViewState) {
        renderMovieList(viewState.movieList)
    }

    private fun renderMovieList(movieList: List<Movie>) {
        movieAdapter.submitList(movieList)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    private fun navigateMovieDetail(id: Int) {
        val action =
            MovieListFragmentDirections.actionMoviePopularListFragmentToMovieDetailFragment(
                id
            )
        findNavController().navigate(action)
    }
}
