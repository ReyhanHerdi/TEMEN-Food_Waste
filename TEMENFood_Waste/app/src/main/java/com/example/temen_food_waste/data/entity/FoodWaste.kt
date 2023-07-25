package com.example.temen_food_waste.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = User::class,
    childColumns = ["id_user"],
    parentColumns = ["id_user"]
)])
data class FoodWaste (
    @PrimaryKey(autoGenerate = true) val id_foodwaste: Int? = null,
    @ColumnInfo(name = "nama_foodwaste") val nama_foodwaste: String?,
    @ColumnInfo(name = "deskr_foodwaste") val deskr_foodwaste: String?,
    @ColumnInfo(name = "foto_foodwaste") val foto_foodwaste: String? = null,
    @ColumnInfo(name = "stok") val stok: Int? = 0,
    @ColumnInfo(name = "harga") val harga: Int?,
    @ColumnInfo(name = "kategori") val kategori: String? = null,
    @ColumnInfo(name = "id_user") val id_user: Int?,
)