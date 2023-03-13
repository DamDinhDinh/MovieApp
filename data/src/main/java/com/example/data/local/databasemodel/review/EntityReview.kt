package com.example.data.local.databasemodel.review

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity(tableName = "review")
data class EntityReview(
    var author: String = DEFAULT_STRING,
    var authorDetails: EntityAuthorDetails = EntityAuthorDetails(
        DEFAULT_STRING,
        DEFAULT_STRING,
        DEFAULT_INT,
        DEFAULT_STRING
    ), // save as json object
    var content: String = DEFAULT_STRING,
    var createdAt: String = DEFAULT_STRING,
    @PrimaryKey
    @ColumnInfo(name = "reviewId")
    var id: String = DEFAULT_STRING,
    var iso6391: String = DEFAULT_STRING,
    var mediaId: String = DEFAULT_STRING,
    var mediaTitle: String = DEFAULT_STRING,
    var mediaType: String = DEFAULT_STRING,
    var updatedAt: String = DEFAULT_STRING,
    var url: String = DEFAULT_STRING,
    var movieId: String = DEFAULT_STRING,
    var tvShowId: String = DEFAULT_STRING
)