package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class ProfileActivity : AppCompatActivity() {
    private lateinit var buttonUpload: ImageButton
    private lateinit var buttonBuy: ImageButton
    private lateinit var buttonHome: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        buttonUpload = findViewById(R.id.buttonUpload)
        buttonBuy = findViewById(R.id.buttonBuy)
        buttonHome = findViewById(R.id.buttonHome)

        buttonUpload.setOnClickListener {
            startActivity(Intent(this, UploadActivity::class.java))
        }

        buttonBuy.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        buttonHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}