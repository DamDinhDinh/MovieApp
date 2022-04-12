package com.example.movieapp.presenter.common.adapter

import androidx.recyclerview.widget.RecyclerView

open abstract class BaseRvAdapter<T, VH : RecyclerView.ViewHolder?> : RecyclerView.Adapter<VH>() {
    protected val itemList = mutableListOf<T>()

    fun updateItems(itemList: List<T>) {
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}