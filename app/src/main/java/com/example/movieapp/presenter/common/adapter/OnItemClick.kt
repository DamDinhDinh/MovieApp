package com.example.movieapp.presenter.common.adapter

interface OnItemClick<T> {
    fun onClick(item: T, position: Int)
}