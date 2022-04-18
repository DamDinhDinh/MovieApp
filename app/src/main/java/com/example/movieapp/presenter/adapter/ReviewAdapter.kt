package com.example.movieapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.movieapp.databinding.ItemReviewBinding
import com.example.movieapp.presenter.adapter.ReviewAdapter.ViewHolder
import com.example.movieapp.presenter.model.review.Review

open class ReviewAdapter(private val onItemClick: (review: Review) -> Unit) :
    ListAdapter<Review, ViewHolder>(ReviewDiff()) {

    class ReviewDiff : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(
        private val itemReviewBinding: ItemReviewBinding,
        private val onItemClick: (review: Review) -> Unit
    ) :
        RecyclerView.ViewHolder(itemReviewBinding.root) {

        private var review: Review? = null

        init {
            itemReviewBinding.root.setOnClickListener { review?.let { onItemClick(it) } }
        }

        fun bindView(review: Review) {
            itemReviewBinding.run {
                tvCreateAt.text = review.createdAt.substring(0, 10)
                tvReviewContent.text = review.content
                tvAuthorName.text = review.author
                tvAuthorRate.text =
                    if (review.authorDetails.rating != DEFAULT_INT) review.authorDetails.rating.toString() else ""
                Glide.with(imgAuthorAvatar).load(review.authorDetails.avatarPath)
                    .into(imgAuthorAvatar)
            }

            this.review = review
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }
}