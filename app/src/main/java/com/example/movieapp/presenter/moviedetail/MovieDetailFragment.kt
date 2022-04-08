package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.MyApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.presenter.model.movie.Movie
import javax.inject.Inject

class MovieDetailFragment : Fragment(), MovieDetailContract.View {
    private val TAG = "MovieDetailFragment"

    @Inject
    lateinit var viewModel: MovieDetailContract.ViewModel

    lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (activity?.application as MyApplication).appComponent
        appComponent.inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        activity?.title = resources.getString(R.string.movie_detail_screen)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchMovie(args.id)
        viewModel.observeViewState()
            .observe(viewLifecycleOwner, { viewState -> renderMovie(viewState.movie) })
    }

    override fun updateViewState(viewState: MovieDetailContract.ViewState) {
        renderMovie(viewState.movie)
    }

    private fun renderMovie(movie: Movie) {

        Glide.with(this).load(movie.backdropPath).into(binding.imgMovieBackdrop)
        binding.tvMovieTitle.text = movie.title
//        binding.tvMovieTitle.tvMovieCategory = movie.
        binding.tvMovieDuration.text = movie.runtime.toString()
        binding.expandableText.text = movie.overview
    }
}