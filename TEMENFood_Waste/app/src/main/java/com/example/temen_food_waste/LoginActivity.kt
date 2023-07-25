package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.temen_food_waste.data.AppDatabase

@Suppress("SENSELESS_COMPARISON")
class LoginActivity : AppCompatActivity() {
    private lateinit var email: TextView
    private lateinit var password: TextView
    private lateinit var buttonLogin: ImageButton
    private lateinit var goToRegister: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        buttonLogin = findViewById(R.id.buttonLogin)
        goToRegister = findViewById(R.id.goToRegister)

        database = AppDatabase.getInstance(applicationContext)
        buttonLogin.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                if (database.userDao().login(email.text.toString(), password.text.toString()).isNotEmpty()) {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("Email User", email.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Email atau password salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "Masukkan email dan passoword!", Toast.LENGTH_SHORT).show()
            }
        }
        goToRegister.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}