package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    private lateinit var buttonLogin: Button
    private lateinit var goToRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.buttonLogin)
        goToRegister = findViewById(R.id.goToRegister)

        buttonLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        goToRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}