package com.example.movieapp.presenter.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ItemGenreBinding
import com.example.movieapp.presenter.common.adapter.GenreAdapter.ViewHolder
import com.example.movieapp.presenter.model.movie.Genre

class GenreAdapter(private val onItemClick: OnItemClick<Genre>) :
    BaseRvAdapter<Genre, ViewHolder>() {

    class ViewHolder(
        private val itemGenreBinding: ItemGenreBinding,
        private val onItemClick: OnItemClick<Genre>
    ) :
        RecyclerView.ViewHolder(itemGenreBinding.root) {

        fun bindView(genre: Genre, position: Int) {
            itemGenreBinding.run {
                tvGenreType.text = genre.name
                root.setOnClickListener { onItemClick.onClick(genre, position) }
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
        holder.bindView(itemList[position], position)
    }
}