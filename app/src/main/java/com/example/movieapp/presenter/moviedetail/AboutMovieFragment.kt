package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentAboutMovieBinding
import com.example.movieapp.presenter.model.movie.Movie
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * Created by dinhdd damdinhdinh.mum@gmail.com on 4/12/2022.
 */

@AndroidEntryPoint
class AboutMovieFragment : Fragment(), MovieDetailContract.View {

    class Params

    companion object {
        fun newInstance(param: Params): AboutMovieFragment {
            return AboutMovieFragment()
        }
    }

    private val TAG = "AboutMovieFragment"

    private val viewModel: MovieDetailContract.ViewModel by viewModels<MovieDetailViewModel>(
        ownerProducer = { requireParentFragment() })

    private val binding: FragmentAboutMovieBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            observeViewState().observe(viewLifecycleOwner) { renderMovie(it.movie) }
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
            tvOverview.text = root.context.getString(R.string.overviews_label, movie.overview)
            tvReleaseDate.text =
                root.context.getString(R.string.release_date_label, movie.releaseDate)
            tvAverageRating.text =
                root.context.getString(R.string.average_rating_label, movie.voteAverage.toString())
            tvRateCount.text =
                root.context.getString(R.string.rate_count_label, movie.voteCount.toString())
            tvPopularity.text =
                root.context.getString(R.string.popularity_label, movie.popularity.toString())
        }
    }
}