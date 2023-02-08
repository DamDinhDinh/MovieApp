package com.example.movieapp.presenter.ui.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private val viewModel: MovieListContract.ViewModel by viewModels<MovieListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieListScreen(viewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            if (observeViewState().value == null) {
                fetchMoviePopular()
            }
            observeNavigate()
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .flowOn(Dispatchers.Main)
                .onEach { navigate ->
                    when (navigate) {
                        is MovieListContract.NavigateEvent.NavigateMovieDetail -> navigateMovieDetail(navigate.movie.id)
                    }
                }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun navigateMovieDetail(id: String) {
        findNavController().navigate(MovieListFragmentDirections.actionMoviePopularListFragmentToMovieDetailFragment(id))
    }
}
