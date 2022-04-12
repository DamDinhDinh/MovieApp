package com.example.movieapp.presenter.moviepopularlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.MyApplication
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMoviePopularListBinding
import com.example.movieapp.presenter.common.adapter.OnItemClick
import com.example.movieapp.presenter.model.moviepopular.MoviePopular
import javax.inject.Inject

class MoviePopularListFragment : Fragment(), MoviePopularListContract.View {

    private val TAG = "MoviePopularListFragment"

    @Inject
    lateinit var vmFactory: MoviePopularListViewModel.Factory
    lateinit var viewModel: MoviePopularListContract.ViewModel

    lateinit var binding: FragmentMoviePopularListBinding
    private val movieAdapter = MoviePopularAdapter(object : OnItemClick<MoviePopular> {
        override fun onClick(item: MoviePopular, position: Int) {
            navigateMovieDetail(item.id)
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

        binding = FragmentMoviePopularListBinding.inflate(inflater, container, false)

        activity?.title = resources.getString(R.string.movie_popular_screen)
        binding.rcMoviePopular.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, vmFactory)[MoviePopularListViewModel::class.java]

        viewModel.apply {
            fetchMoviePopular()
            observeViewState().observe(viewLifecycleOwner) { viewState -> updateViewState(viewState) }
        }
    }


    override fun onResume() {
        super.onResume()
        println("$TAG viewmodel hash {${viewModel.hashCode()}}")
    }

    override fun updateViewState(viewState: MoviePopularListContract.ViewState) {
        println("$TAG updateViewState $viewState")
        renderMovieList(viewState.movieList)
    }

    private fun renderMovieList(movieList: List<MoviePopular>) {
        movieAdapter.updateItems(movieList)
    }

    private fun navigateMovieDetail(id: Int) {
        val action =
            MoviePopularListFragmentDirections.actionMoviePopularListFragmentToMovieDetailFragment(
                id
            )
        findNavController().navigate(action)
    }
}