package com.example.data.local.databasemodel.roomdatabase.typeconverter

import androidx.room.TypeConverter
import com.example.data.local.databasemodel.review.EntityAuthorDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ReviewTypeConverters {

    @TypeConverter
    fun authorDetailsToJson(authorDetails: EntityAuthorDetails): String {
        return Gson().toJson(authorDetails, object : TypeToken<EntityAuthorDetails>() {}.type)
    }

    @TypeConverter
    fun jsonToAuthorDetails(json: String): EntityAuthorDetails {
        return Gson().fromJson(json, EntityAuthorDetails::class.java)
    }
}