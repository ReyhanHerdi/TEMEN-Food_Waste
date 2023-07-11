package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.temen_food_waste.data.AppDatabase
import com.example.temen_food_waste.data.entity.User

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonBackLogin: ImageButton
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.confirmPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonBackLogin = findViewById(R.id.buttonBackLogin)

        database = AppDatabase.getInstance(applicationContext)

        buttonRegister.setOnClickListener {
            if (username.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty()){
                try {
                    database.userDao().insertAll(
                        User(
                            null,
                            username.text.toString(),
                            email.text.toString(),
                            password.text.toString(),
                            null,
                            0,
                            null,
                            null
                        )

                    )

                    Toast.makeText(applicationContext, "isi Data Berhasil", Toast.LENGTH_SHORT).show()

                    try {
                        startActivity(Intent(this, LoginActivity::class.java))
                    } catch (e: Exception) {
                        Toast.makeText(applicationContext, "Pindah halaman Gagal", Toast.LENGTH_SHORT).show()
                    }

                } catch (e: Exception) {
                    Toast.makeText(applicationContext, "isi Data Gagal: ", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(applicationContext, "isi Data", Toast.LENGTH_SHORT).show()
            }
        }

        buttonBackLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}