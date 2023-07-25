package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.temen_food_waste.data.AppDatabase
import com.example.temen_food_waste.data.entity.FoodWaste


class UploadActivity : AppCompatActivity() {
    private lateinit var buttonHome: ImageButton
    private lateinit var buttonBuy: ImageButton
    private lateinit var buttonProfile: ImageButton
    private lateinit var buttonUpload_foodwaste: ImageButton
    private lateinit var nama_foodwaste: TextView
    private lateinit var desk_foodwaste: TextView
    private lateinit var stok: TextView
    private lateinit var harga: TextView
    private lateinit var email: TextView
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        email = findViewById(R.id.email)
        nama_foodwaste = findViewById(R.id.nama_foodwaste)
        desk_foodwaste = findViewById(R.id.desk_foodwaste)
        stok = findViewById(R.id.stok)
        harga = findViewById(R.id.harga)

        database = AppDatabase.getInstance(applicationContext)

        buttonHome = findViewById(R.id.buttonHome)
        buttonBuy = findViewById(R.id.buttonBuy)
        buttonProfile = findViewById(R.id.buttonProfile)
        buttonUpload_foodwaste = findViewById(R.id.buttonUploadFoodWaste)

        Log.d("Teest", "lagi jalan")

        buttonUpload_foodwaste.setOnClickListener {
            Log.d("test", "Tombol diklik")
            if (desk_foodwaste.text.isNotEmpty() && stok.text.isNotEmpty() && harga.text.isNotEmpty()) {
                try {
                    database.foodwasteDAO().insertAll(
                        FoodWaste(
                            null,
                            nama_foodwaste.text.toString(),
                            desk_foodwaste.text.toString(),
                            null,
                            stok.text.toString().toInt(),
                            harga.text.toString().toInt(),
                            null,
                            1 //database.userDao().getIdUser(email.text.toString()).toString().toInt() // email gak kebaca
                        )
                    )
                    Log.d("test", "data berhasil")
                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "Isi data gagal", Toast.LENGTH_SHORT).show()
                    Log.d("test", e.toString())
                    /*Log.d("data type",
                        database.userDao().getIdUser(email.text.toString()).toString()
                    )
                    Log.d("email", email.text.toString()) */
                }
            } else {
                Toast.makeText(applicationContext, "Isi semua data", Toast.LENGTH_SHORT).show()
                Log.d("Teest", "data kosong")
            }
        }

        buttonHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        buttonBuy.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        buttonProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}