package com.example.movieapp.presenter.moviedetail.controller.model

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.example.movieapp.R
import com.example.movieapp.common.EpoxyViewBindingModelWithHolder
import com.example.movieapp.databinding.ListItemMovieDetailGenreBinding
import com.example.movieapp.presenter.model.movie.Genre

@EpoxyModelClass(layout = R.layout.list_item_movie_detail_genre)
abstract class MovieDetailGenreModel: EpoxyViewBindingModelWithHolder<ListItemMovieDetailGenreBinding>(){

    @EpoxyAttribute
    lateinit var movieGenres: List<Genre>

    override fun ListItemMovieDetailGenreBinding.bind(context: Context) {
        carouselGenre.apply {
            setPadding(Carousel.Padding.dp(0, 6))
            withModels {
                movieGenres.forEachIndexed { index, itemGenre ->
                    movieGenreItem {
                        id("MOVIE_ITEM_GENRE", index.toString(), itemGenre.id.toString(), "${itemGenre.name}$index$id")
                        genre(itemGenre)
                    }
                }
            }
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            isNestedScrollingEnabled = false
        }
    }
}