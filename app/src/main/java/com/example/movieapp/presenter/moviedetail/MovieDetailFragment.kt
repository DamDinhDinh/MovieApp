package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.presenter.adapter.AboutMoviePagerAdapter
import com.example.movieapp.presenter.adapter.GenreAdapter
import com.example.movieapp.presenter.common.itemdecoration.SpacingItemDecoration
import com.example.movieapp.presenter.common.utils.toPx
import com.example.movieapp.presenter.model.movie.Movie
import com.example.movieapp.presenter.moviedetail.controller.MovieDetailController
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment(), MovieDetailContract.View {
    private val TAG = "MovieDetailFragment"

    @Inject
    lateinit var mController: MovieDetailController
    private val viewModel: MovieDetailContract.ViewModel by viewModels<MovieDetailViewModel>()

    private val binding: FragmentMovieDetailBinding by viewBinding(CreateMethod.INFLATE)
    private val args: MovieDetailFragmentArgs by navArgs()
    private val genreAdapter = GenreAdapter {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = mController.adapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

//        binding.apply {
//            rvGenre.apply {
//                adapter = genreAdapter
//                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                addItemDecoration(SpacingItemDecoration(end = 12.toPx().toInt()))
//            }
//
//            viewPagerInfo.apply {
//                adapter = AboutMoviePagerAdapter(this@MovieDetailFragment)
//            }
//        }
//
//        TabLayoutMediator(
//            binding.tabLayoutInfo,
//            binding.viewPagerInfo
//        ) { tab, position ->
//            tab.text = when (position) {
//                0 -> context?.getString(R.string.about_movie_label)
//                1 -> context?.getString(R.string.reviews_label)
//                else -> ""
//            }
//        }.attach()

        viewModel.apply {
            observeViewState().observe(viewLifecycleOwner) { updateViewState(it) }
            if (observeViewState().value == null) {
                fetchMovie(args.id)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.v("$TAG onResume viewModel = ${viewModel.hashCode()}")
    }

    override fun updateViewState(viewState: MovieDetailContract.ViewState) {
//        renderMovie(viewState.movie)
        mController.setData(viewState)
    }

    private fun renderMovie(movie: Movie) {


//        binding.apply {
//            Glide.with(root.context).load(movie.backdropPathFull).into(imvMovieBackdrop)
//            Glide.with(root.context).load(movie.posterPathFull)
//                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(16.toPx().toInt())))
//                .into(imvMovieAvatar)
//            tvTitle.text = movie.title
//            genreAdapter.submitList(movie.genres)
//        }
    }
}