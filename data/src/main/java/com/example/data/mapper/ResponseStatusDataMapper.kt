package com.example.data.mapper

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.jsonmodel.JsonResponseStatus
import com.example.domain.model.ModelResponseStatus

fun JsonResponseStatus.toModel() =
    ModelResponseStatus(statusCode ?: DEFAULT_INT, statusMessage ?: DEFAULT_STRING)

fun ModelResponseStatus.toJson() = JsonResponseStatus(statusCode, statusMessage)