package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.MyApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.presenter.common.adapter.AboutMoviePagerAdapter
import com.example.movieapp.presenter.common.adapter.GenreAdapter
import com.example.movieapp.presenter.common.itemdecoration.SpacingItemDecoration
import com.example.movieapp.presenter.common.utils.toPx
import com.example.movieapp.presenter.model.movie.Movie
import com.google.android.material.tabs.TabLayoutMediator
import timber.log.Timber
import javax.inject.Inject

class MovieDetailFragment : Fragment(), MovieDetailContract.View {
    private val TAG = "MovieDetailFragment"

    @Inject
    lateinit var vmFactory: MovieDetailViewModel.Factory
    lateinit var viewModel: MovieDetailContract.ViewModel

    private val binding: FragmentMovieDetailBinding by viewBinding(CreateMethod.INFLATE)
    private val args: MovieDetailFragmentArgs by navArgs()
    private val genreAdapter = GenreAdapter {}

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvGenre.apply {
            adapter = genreAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(SpacingItemDecoration(end = 12.toPx().toInt()))
        }

        binding.viewPagerInfo.apply {
            adapter = AboutMoviePagerAdapter(this@MovieDetailFragment)
        }
        TabLayoutMediator(
            binding.tabLayoutInfo,
            binding.viewPagerInfo
        ) { tab, position ->
            run {
                tab.text = when (position) {
                    0 -> context?.getString(R.string.about_movie_label)
                    1 -> context?.getString(R.string.reviews_label)
                    else -> ""
                }
            }
        }.attach()

        viewModel = ViewModelProvider(this, vmFactory)[MovieDetailViewModel::class.java]
        viewModel.apply {
            fetchMovie(args.id)
            observeViewState()
                .observe(viewLifecycleOwner) { viewState -> renderMovie(viewState.movie) }
        }
    }

    override fun onResume() {
        super.onResume()
        Timber.v("$TAG onResume viewModel = ${viewModel.hashCode()}")
    }

    override fun updateViewState(viewState: MovieDetailContract.ViewState) {
        renderMovie(viewState.movie)
    }

    private fun renderMovie(movie: Movie) {

        binding.apply {
            Glide.with(root.context).load(movie.backdropPath).into(imvMovieBackdrop)
            Glide.with(root.context).load(movie.posterPath)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(16.toPx().toInt())))
                .into(imvMovieAvatar)
            tvTitle.text = movie.title
            genreAdapter.updateItems(movie.genres)
        }
    }
}