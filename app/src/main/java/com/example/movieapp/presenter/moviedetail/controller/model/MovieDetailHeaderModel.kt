package com.example.movieapp.presenter.moviedetail.controller.model

import android.content.Context
import com.airbnb.epoxy.*
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.common.EpoxyViewBindingModelWithHolder
import com.example.movieapp.databinding.ListItemMovieDetailHeaderBinding

@EpoxyModelClass(layout = R.layout.list_item_movie_detail_header)
abstract class MovieDetailHeaderModel: EpoxyViewBindingModelWithHolder<ListItemMovieDetailHeaderBinding>() {

    @EpoxyAttribute
    lateinit var movieBackDropUrl: String

    @EpoxyAttribute
    lateinit var movieAvatarUrl: String

    @EpoxyAttribute
    lateinit var movieTitle: String

    override fun ListItemMovieDetailHeaderBinding.bind(context: Context) {
        Glide.with(context).load(movieBackDropUrl).into(imvMovieBackdrop)
        Glide.with(context).load(movieAvatarUrl).into(imvMovieAvatar)
        tvTitle.text = movieTitle
    }
}