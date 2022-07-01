package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapp.presenter.moviedetail.review.ReviewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReviewMovieFragment : Fragment() {

    class Params

    companion object {
        const val TAG = "ReviewMovieFragment"

        fun newInstance(param: Params): ReviewMovieFragment {
            return ReviewMovieFragment()
        }
    }

    private val detailViewModel: MovieDetailContract.ViewModel by viewModels<MovieDetailViewModel>(
        ownerProducer = { requireParentFragment() })
    private val reviewViewModel: MovieReviewContract.ViewModel by viewModels<MovieReviewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ReviewScreen(reviewViewModel)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (reviewViewModel.observeViewState().value == null) {
            detailViewModel.observeViewState()
                .observe(viewLifecycleOwner) { viewState -> reviewViewModel.fetchReviews(viewState.movie.id) }
        }
    }
}