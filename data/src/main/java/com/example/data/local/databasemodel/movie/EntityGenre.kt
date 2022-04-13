package com.example.data.local.databasemodel.movie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity
data class EntityGenre(
    @PrimaryKey
    var id: Int = DEFAULT_INT,
    var name: String = DEFAULT_STRING
)