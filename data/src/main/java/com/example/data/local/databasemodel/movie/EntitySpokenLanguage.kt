package com.example.data.local.databasemodel.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

data class EntitySpokenLanguage(
    var iso6391: String = DEFAULT_STRING,
    var name: String = DEFAULT_STRING
)