package com.example.data.local.databasemodel.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity(tableName = "genre")
data class EntityGenre(
    @PrimaryKey
    @ColumnInfo(name = "genreId")
    var id: String = DEFAULT_STRING,
    var name: String = DEFAULT_STRING
)