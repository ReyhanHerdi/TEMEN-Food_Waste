package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class RequestActivity : AppCompatActivity() {
    private lateinit var checkout : TextView
    private lateinit var buttonHome: ImageButton
    private lateinit var buttonUpload: ImageButton
    private lateinit var buttonProfile: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)

        checkout = findViewById(R.id.checkout)
        buttonHome = findViewById(R.id.buttonHome)
        buttonUpload = findViewById(R.id.buttonUpload)
        buttonProfile = findViewById(R.id.buttonProfile)

        checkout.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        buttonHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        buttonUpload.setOnClickListener {
            startActivity(Intent(this, UploadActivity::class.java))
        }

        buttonProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}