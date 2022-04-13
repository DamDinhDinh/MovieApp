package com.example.data.remote.jsonmodel.movie


import com.google.gson.annotations.SerializedName

data class JsonSpokenLanguage(
    @SerializedName("iso_639_1")
    val iso6391: String?,
    @SerializedName("name")
    val name: String?
)