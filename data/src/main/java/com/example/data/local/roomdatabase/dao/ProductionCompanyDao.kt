package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityProductionCompany

@Dao
abstract class ProductionCompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(vararg entities: EntityProductionCompany)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(vararg entities: EntityProductionCompany)

    @Delete
    abstract suspend fun delete(vararg entities: EntityProductionCompany)
}