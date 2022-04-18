package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.movieapp.MyApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentAboutMovieBinding
import com.example.movieapp.presenter.model.movie.Movie
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by dinhdd damdinhdinh.mum@gmail.com on 4/12/2022.
 */
class AboutMovieFragment : Fragment(), MovieDetailContract.View {

    class Params

    companion object {
        fun newInstance(param: Params): AboutMovieFragment {
            return AboutMovieFragment()
        }
    }

    private val TAG = "AboutMovieFragment"

    @Inject
    lateinit var vmFactory: MovieDetailViewModel.Factory
    lateinit var viewModel: MovieDetailContract.ViewModel

    private val binding: FragmentAboutMovieBinding by viewBinding(CreateMethod.INFLATE)

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

        viewModel = ViewModelProvider(
            requireParentFragment().viewModelStore, vmFactory
        )[MovieDetailViewModel::class.java]
            .apply {
                observeViewState()
                    .observe(viewLifecycleOwner) { renderMovie(it.movie) }
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