package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityProductionCompany

@Dao
abstract class ProductionCompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityProductionCompany)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityProductionCompany)

    @Delete
    abstract fun delete(vararg entities: EntityProductionCompany)
}