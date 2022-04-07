package com.example.movieapp.presenter.mapper.movie

import com.example.movieapp.domain.model.movie.ModelSpokenLanguage
import com.example.movieapp.presenter.model.movie.SpokenLanguage

class SpokenLanguageMapper

fun SpokenLanguage.toModel() = ModelSpokenLanguage(iso6391, name)

fun ModelSpokenLanguage.toPresent() = SpokenLanguage(iso6391, name)