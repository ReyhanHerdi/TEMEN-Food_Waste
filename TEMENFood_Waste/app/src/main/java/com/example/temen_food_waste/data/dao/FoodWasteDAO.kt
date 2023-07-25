package com.example.temen_food_waste.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.temen_food_waste.data.entity.FoodWaste

@Dao
interface FoodWasteDAO {
    @Query("SELECT * FROM FoodWaste")
    fun getAll(): List<FoodWaste>

    @Insert
    fun insertAll(vararg foodWaste: FoodWaste)
}