package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapp.MyApplication
import com.example.movieapp.databinding.FragmentMovieReviewsBinding
import com.example.movieapp.presenter.adapter.ReviewAdapter
import com.example.movieapp.presenter.common.itemdecoration.SpacingItemDecoration
import com.example.movieapp.presenter.common.utils.toPx
import com.example.movieapp.presenter.model.review.Review
import timber.log.Timber
import javax.inject.Inject

class ReviewMovieFragment : Fragment(), MovieReviewContract.View {

    private val TAG = "ReviewMovieFragment"

    @Inject
    lateinit var detailVmFactory: MovieDetailViewModel.Factory

    @Inject
    lateinit var reviewVmFactory: MovieReviewsViewModel.Factory

    lateinit var detailViewModel: MovieDetailContract.ViewModel
    lateinit var reviewViewModel: MovieReviewContract.ViewModel

    private val binding: FragmentMovieReviewsBinding by viewBinding(CreateMethod.INFLATE)
    private val reviewAdapter = ReviewAdapter {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (activity?.application as MyApplication).appComponent
        appComponent.inject(this)
    }

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

        detailViewModel = ViewModelProvider(
            requireParentFragment().viewModelStore,
            detailVmFactory
        )[MovieDetailViewModel::class.java]
        detailViewModel.apply {
            observeViewState()
                .observe(viewLifecycleOwner) {
                        viewState ->
                    reviewViewModel.fetchReviews(viewState.movie.id)
                    Timber.d("$TAG detailViewModel observeViewState $viewState")
                }
        }

        reviewViewModel = ViewModelProvider(
            this,
            reviewVmFactory
        )[MovieReviewsViewModel::class.java]
        reviewViewModel.observeViewState()
            .observe(viewLifecycleOwner) { viewState -> updateViewState(viewState) }
    }

    override fun updateViewState(viewState: MovieReviewContract.ViewState) {
        Timber.d("$TAG updateViewState $viewState")
        renderListReview(viewState.reviews)
    }

    private fun renderListReview(reviews: List<Review>) {
        reviewAdapter.submitList(reviews)
    }
}