package com.example.data.local.databasemodel.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity(tableName = "production_company")
data class EntityProductionCompany(
    @PrimaryKey
    @ColumnInfo(name = "companyId")
    var id: String = DEFAULT_STRING,
    var logoPath: String = DEFAULT_STRING,
    var name: String = DEFAULT_STRING,
    var originCountry: String = DEFAULT_STRING
)