package com.example.movieapp.data.entities.movie


import com.google.gson.annotations.SerializedName

data class JsonSpokenLanguage(
    @SerializedName("iso_639_1")
    val iso6391: String?,
    @SerializedName("name")
    val name: String?
)