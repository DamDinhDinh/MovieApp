package com.example.data.jsonmodel.review


import com.google.gson.annotations.SerializedName

data class JsonReview(
    @SerializedName("author")
    val author: String?,
    @SerializedName("author_details")
    val authorDetails: JsonAuthorDetails?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("iso_639_1")
    val iso6391: String?,
    @SerializedName("media_id")
    val mediaId: Int?,
    @SerializedName("media_title")
    val mediaTitle: String?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?
)