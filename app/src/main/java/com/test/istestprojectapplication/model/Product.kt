package com.test.istestprojectapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.istestprojectapplication.model.Product.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Product(

    @PrimaryKey
    val id : Long,
    val name : String,
    val description : String,
    val price : Int,
    val itemRate : Int) {
    companion object {
        const val TABLE_NAME = "Products"
    }
}