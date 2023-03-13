package com.example.data.remote.jsonmodel.movie


import com.google.gson.annotations.SerializedName

data class JsonGenre(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)