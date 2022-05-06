package com.example.movieapp.presenter.moviedetail.controller.model

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.movieapp.R
import com.example.movieapp.common.EpoxyViewBindingModelWithHolder
import com.example.movieapp.databinding.ItemGenreBinding
import com.example.movieapp.presenter.model.movie.Genre

@EpoxyModelClass(layout = R.layout.item_genre)
abstract class MovieGenreItemModel : EpoxyViewBindingModelWithHolder<ItemGenreBinding>() {

    @EpoxyAttribute
    lateinit var genre: Genre

    override fun ItemGenreBinding.bind(context: Context) {
        with(genre){
            tvGenreType.text = name
        }
    }
}