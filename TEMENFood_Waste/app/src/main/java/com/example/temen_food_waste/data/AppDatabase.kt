package com.example.temen_food_waste.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.temen_food_waste.data.dao.FoodWasteDAO
import com.example.temen_food_waste.data.dao.UserDAO
import com.example.temen_food_waste.data.entity.FoodWaste
import com.example.temen_food_waste.data.entity.User

@Database(entities = [User::class, FoodWaste::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun foodwasteDAO(): FoodWasteDAO

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }

            return instance!!
        }
    }
}