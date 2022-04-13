package com.example.data.local.databasemodel.review

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

data class EntityAuthorDetails(
    var avatarPath: String = DEFAULT_STRING,
    var name: String = DEFAULT_STRING,
    var rating: Int = DEFAULT_INT,
    var username: String = DEFAULT_STRING
)