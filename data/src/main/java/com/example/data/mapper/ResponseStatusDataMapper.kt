package com.example.data.mapper

import com.example.data.jsonmodel.JsonResponseStatus
import com.example.domain.model.ModelResponseStatus

fun JsonResponseStatus.toModel() = ModelResponseStatus(statusCode, statusMessage)
fun ModelResponseStatus.toJson() = JsonResponseStatus(statusCode, statusMessage)