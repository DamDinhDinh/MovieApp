package com.example.data.remote.jsonmodel.movie


import com.google.gson.annotations.SerializedName

data class JsonProductionCompany(
    @SerializedName("id")
    val id: String?,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)