package com.example.movieapp.data.entities.movie


import com.google.gson.annotations.SerializedName

data class JsonGenre(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)