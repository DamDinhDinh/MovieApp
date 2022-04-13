package com.example.data.remote.jsonmodel


import com.google.gson.annotations.SerializedName

data class JsonResponseStatus(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status_message")
    val statusMessage: String?,
)