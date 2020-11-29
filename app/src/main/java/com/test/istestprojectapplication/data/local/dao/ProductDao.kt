package com.test.istestprojectapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.istestprojectapplication.model.Product
import io.reactivex.Completable
import io.reactivex.Single


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products : List<Product>) : Completable

    @Query("SELECT * FROM ${Product.TABLE_NAME}")
    fun getAllProducts() : Single<List<Product>>
}