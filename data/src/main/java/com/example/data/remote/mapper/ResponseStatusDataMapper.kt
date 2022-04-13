package com.example.data.remote.mapper

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.JsonResponseStatus
import com.example.domain.model.ModelResponseStatus

fun JsonResponseStatus.toModel() =
    ModelResponseStatus(statusCode ?: DEFAULT_INT, statusMessage ?: DEFAULT_STRING)

fun ModelResponseStatus.toJson() = JsonResponseStatus(statusCode, statusMessage)