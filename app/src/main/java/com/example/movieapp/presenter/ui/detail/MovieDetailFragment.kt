package com.example.movieapp.presenter.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.movieapp.presenter.ui.detail.view.review.MovieReviewContract
import com.example.movieapp.presenter.ui.detail.view.review.MovieReviewsViewModel
import com.example.movieapp.presenter.moviedetail.detail.DetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    private val TAG = "MovieDetailFragment"

    private val viewModel: MovieDetailContract.ViewModel by viewModels<MovieDetailViewModel>()
    private val reviewsViewModel: MovieReviewContract.ViewModel by viewModels<MovieReviewsViewModel>()

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                DetailScreen(viewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apply {
            if (observeViewState().value == null) {
                fetchMovie(args.id)
            }
        }
        reviewsViewModel.apply {
            if (observeViewState().value == null) {
                reviewsViewModel.fetchReviews(args.id)
            }
        }
    }
}