package com.example.movieapp.presenter.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemGenreBinding
import com.example.movieapp.presenter.common.adapter.GenreAdapter.ViewHolder
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

        fun bindView(genre: Genre, position: Int) {
            itemGenreBinding.run {
                tvGenreType.text = genre.name
                root.setOnClickListener { onItemClick(genre) }
            }
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
        holder.bindView(getItem(position), position)
    }

    fun updateItems(itemList: List<Genre>) {
        submitList(itemList)
    }
}