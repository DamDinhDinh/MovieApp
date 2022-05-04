package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapp.databinding.FragmentMovieReviewsBinding
import com.example.movieapp.presenter.adapter.ReviewAdapter
import com.example.movieapp.presenter.common.itemdecoration.SpacingItemDecoration
import com.example.movieapp.presenter.common.utils.toPx
import com.example.movieapp.presenter.model.review.Review
import timber.log.Timber

class ReviewMovieFragment : Fragment(), MovieReviewContract.View {

    class Params

    companion object {
        fun newInstance(param: Params): ReviewMovieFragment {
            return ReviewMovieFragment()
        }
    }

    private val TAG = "ReviewMovieFragment"

    private val detailViewModel: MovieDetailContract.ViewModel by viewModels<MovieDetailViewModel>(
        ownerProducer = { requireParentFragment() })
    private val reviewViewModel: MovieReviewContract.ViewModel by viewModels<MovieReviewsViewModel>()

    private val binding: FragmentMovieReviewsBinding by viewBinding(CreateMethod.INFLATE)
    private val reviewAdapter = ReviewAdapter {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Timber.v("$TAG onResume viewModel = ${detailViewModel.hashCode()}")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvReviews.apply {
            adapter = reviewAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(SpacingItemDecoration(bottom = 20.toPx().toInt()))
        }

        reviewViewModel.apply {
            observeViewState().observe(viewLifecycleOwner) { updateViewState(it) }
        }

        if (reviewViewModel.observeViewState().value == null) {
            detailViewModel.observeViewState()
                .observe(viewLifecycleOwner) { viewState -> reviewViewModel.fetchReviews(viewState.movie.id) }
        }
    }

    override fun updateViewState(viewState: MovieReviewContract.ViewState) {
        Timber.d("$TAG updateViewState $viewState")
        renderListReview(viewState.reviews)
    }

    private fun renderListReview(reviews: List<Review>) {
        reviewAdapter.submitList(reviews)
    }
}