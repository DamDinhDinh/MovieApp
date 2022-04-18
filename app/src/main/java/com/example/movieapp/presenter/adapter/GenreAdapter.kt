package com.example.movieapp.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemGenreBinding
import com.example.movieapp.presenter.adapter.GenreAdapter.ViewHolder
import com.example.movieapp.presenter.model.movie.Genre

open class GenreAdapter(private val onItemClick: (genre: Genre) -> Unit) :
    ListAdapter<Genre, ViewHolder>(GenreDiff()) {

    class GenreDiff : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(
        private val itemGenreBinding: ItemGenreBinding,
        private val onItemClick: (genre: Genre) -> Unit
    ) :
        RecyclerView.ViewHolder(itemGenreBinding.root) {

        private var genre: Genre? = null

        init {
            itemGenreBinding.root.setOnClickListener { genre?.let { onItemClick(it) } }
        }

        fun bindView(genre: Genre) {
            itemGenreBinding.run {
                tvGenreType.text = genre.name
            }
            this.genre = genre
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemGenreBinding.inflate(
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