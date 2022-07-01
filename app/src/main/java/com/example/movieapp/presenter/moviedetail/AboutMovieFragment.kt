package com.example.movieapp.presenter.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapp.presenter.moviedetail.about.AboutScreen
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by dinhdd damdinhdinh.mum@gmail.com on 4/12/2022.
 */

@AndroidEntryPoint
class AboutMovieFragment : Fragment() {

    class Params

    companion object {
        const val TAG = "AboutMovieFragment"

        fun newInstance(param: Params): AboutMovieFragment {
            return AboutMovieFragment()
        }
    }

    private val viewModel: MovieDetailContract.ViewModel by viewModels<MovieDetailViewModel>(
        ownerProducer = { requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                AboutScreen(viewModel = viewModel)
            }
        }
    }
}