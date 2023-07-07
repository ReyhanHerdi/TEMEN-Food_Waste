package com.example.temen_food_waste.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id_user: Int? = null,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "password") val password: String?,
    @ColumnInfo(name = "token") val token: String? = null,
    @ColumnInfo(name = "is_email_verified") val is_email_verified: Int = 0,
    @ColumnInfo(name = "foto_profil") val foto_profil: String? = null,
    @ColumnInfo(name = "no_telp") val no_telp: Int? = null,
)