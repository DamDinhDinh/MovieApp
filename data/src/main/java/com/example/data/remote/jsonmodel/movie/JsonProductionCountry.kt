package com.example.data.remote.jsonmodel.movie


import com.google.gson.annotations.SerializedName

data class JsonProductionCountry(
    @SerializedName("iso_3166_1")
    val iso31661: String?,
    @SerializedName("name")
    val name: String?
)