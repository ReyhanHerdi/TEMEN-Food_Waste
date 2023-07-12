package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton


class UploadActivity : AppCompatActivity() {
    private lateinit var buttonHome: ImageButton
    private lateinit var buttonBuy: ImageButton
    private lateinit var buttonProfile: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        buttonHome = findViewById(R.id.buttonHome)
        buttonBuy = findViewById(R.id.buttonBuy)
        buttonProfile = findViewById(R.id.buttonProfile)

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