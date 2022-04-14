package com.example.data.local.roomdatabase.typeconverter

import androidx.room.TypeConverter
import com.example.data.local.databasemodel.movie.EntityProductionCountry
import com.example.data.local.databasemodel.movie.EntitySpokenLanguage
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieTypeConverters {

    @TypeConverter
    fun listSpokenLanguageToJson(genres: List<EntitySpokenLanguage>): String {
        return Gson().toJson(genres, object : TypeToken<List<EntitySpokenLanguage>>() {}.type)
    }

    @TypeConverter
    fun jsonToListSpokenLanguage(json: String): List<EntitySpokenLanguage> {
        return Gson().fromJson(json, Array<EntitySpokenLanguage>::class.java).asList()
    }

    @TypeConverter
    fun listProductionCountryToJson(genres: List<EntityProductionCountry>): String {
        return Gson().toJson(genres, object : TypeToken<List<EntityProductionCountry>>() {}.type)
    }

    @TypeConverter
    fun jsonToListProductionCountry(json: String): List<EntityProductionCountry> {
        return Gson().fromJson(json, Array<EntityProductionCountry>::class.java).asList()
    }
}