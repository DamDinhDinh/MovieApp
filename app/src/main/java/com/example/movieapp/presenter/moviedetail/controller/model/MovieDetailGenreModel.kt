package com.example.movieapp.presenter.moviedetail.controller.model

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.example.movieapp.R
import com.example.movieapp.databinding.ListItemMovieDetailGenreBinding
import com.example.movieapp.presenter.model.movie.Genre

@EpoxyModelClass(layout = R.layout.list_item_movie_detail_genre)
abstract class MovieDetailGenreModel: EpoxyModel<ListItemMovieDetailGenreBinding>(){

    @EpoxyAttribute
    lateinit var movieGenres: List<Genre>

    override fun bind(view: ListItemMovieDetailGenreBinding) {
        super.bind(view)
    }

//    carouselRelatedProduct.apply {
//        setPadding(Carousel.Padding.dp(16, 8))
//        withModels {
//            scgHomeProduct.forEachIndexed { index, scgHomeProduct ->
//                productGrid {
//                    id(
//                        "HOUSE_PLAN_DETAIL_RELATED_PRODUCT",
//                        index.toString(),
//                        scgHomeProduct.sapProductId,
//                        "${scgHomeProduct.displayName}$index$id"
//                    )
//                    product(scgHomeProduct)
//                    productRelay(this@HousePlanDetailProductModel.productRelay)
//                    productGridType(ProductGridType.FIX_WIDTH)
//                }
//            }
//        }
//    }
}