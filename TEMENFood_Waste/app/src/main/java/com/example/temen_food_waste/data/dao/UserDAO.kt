package com.example.temen_food_waste.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.temen_food_waste.data.entity.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id_user IN (:idUser)")
    fun loadAllByIds(idUser: IntArray): List<User>

    @Query("SELECT * FROM user WHERE email = (:emailUser) AND password = (:passwordUser)")
    fun login(emailUser: String, passwordUser: String): List<User>

    @Query("SELECT * FROM user WHERE email = (:emailUser)")
    fun cekEmail(emailUser: String): List<User>

    @Query("SELECT id_user FROM user WHERE email = (:emailUser) LIMIT 1")
    fun getIdUser(emailUser: String): Long?

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}