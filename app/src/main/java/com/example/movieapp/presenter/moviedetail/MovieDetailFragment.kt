package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.movieapp.MyApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailBinding
import com.example.movieapp.presenter.common.adapter.GenreAdapter
import com.example.movieapp.presenter.common.adapter.OnItemClick
import com.example.movieapp.presenter.common.utils.toPx
import com.example.movieapp.presenter.model.movie.Genre
import com.example.movieapp.presenter.model.movie.Movie
import javax.inject.Inject

class MovieDetailFragment : Fragment(), MovieDetailContract.View {
    private val TAG = "MovieDetailFragment"

    @Inject
    lateinit var vmFactory: MovieDetailViewModel.Factory
    lateinit var viewModel: MovieDetailContract.ViewModel

    lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()
    private val genreAdapter = GenreAdapter(object : OnItemClick<Genre> {
        override fun onClick(item: Genre, position: Int) {

        }
    })

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

        binding.rvGenre.apply {
            adapter = genreAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel = ViewModelProvider(this, vmFactory)[MovieDetailViewModel::class.java]
        viewModel.apply {
            fetchMovie(args.id)
            observeViewState()
                .observe(viewLifecycleOwner) { viewState -> renderMovie(viewState.movie) }
        }
    }

    override fun updateViewState(viewState: MovieDetailContract.ViewState) {
        renderMovie(viewState.movie)
    }

    override fun onResume() {
        super.onResume()
        println("$TAG viewmodel hash {${viewModel.hashCode()}}")
    }

    private fun renderMovie(movie: Movie) {

        binding.apply {
            Glide.with(root.context).load(movie.backdropPath).into(imvMovieBackdrop)
            Glide.with(root.context).load(movie.backdropPath)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(16.toPx.toInt())))
                .into(imvMovieAvatar)
            tvTitle.text = movie.title
            genreAdapter.updateItems(movie.genres!!)
        }
    }
}