package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton

class HomeActivity : AppCompatActivity() {
    private lateinit var buttonUpload: ImageButton
    private lateinit var buttonBuy: ImageButton
    private lateinit var buttonProfile: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        buttonUpload = findViewById(R.id.buttonUpload)
        buttonBuy = findViewById(R.id.buttonBuy)
        buttonProfile = findViewById(R.id.buttonProfile)

        val emailUser = intent.getStringExtra("Email User")

        Log.d("Email", emailUser.toString())

        buttonUpload.setOnClickListener {
            val intent = Intent(this, UploadActivity::class.java)
            intent.putExtra("Email user", emailUser.toString())
            startActivity(intent)
        }

        buttonBuy.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        buttonProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}