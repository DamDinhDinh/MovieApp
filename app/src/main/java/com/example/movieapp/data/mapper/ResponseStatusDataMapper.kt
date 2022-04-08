package com.example.movieapp.data.mapper

import com.example.movieapp.data.entities.JsonResponseStatus
import com.example.movieapp.domain.model.ModelResponseStatus

class ResponseStatusDataMapper

fun JsonResponseStatus.toModel() = ModelResponseStatus(statusCode, statusMessage)
fun ModelResponseStatus.toJson() = JsonResponseStatus(statusCode, statusMessage)