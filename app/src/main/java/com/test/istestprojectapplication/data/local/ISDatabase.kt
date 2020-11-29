package com.test.istestprojectapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.istestprojectapplication.data.local.dao.ProductDao
import com.test.istestprojectapplication.model.Product

@Database(
  entities = [Product::class],
  version = 1
)
abstract class ISDatabase : RoomDatabase() {

    abstract fun getProductDao() : ProductDao


    companion object {
        const val DB_NAME = "is_database"

        @Volatile
        private var INSTANCE: ISDatabase? = null

        fun getInstance(context: Context): ISDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ISDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}