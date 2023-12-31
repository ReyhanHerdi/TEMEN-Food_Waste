package com.example.temen_food_waste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private lateinit var buttonRegister: ImageButton
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
            if (username.text.isNotEmpty() &&
                email.text.isNotEmpty() &&
                password.text.isNotEmpty() &&
                confirmPassword.text.toString().equals(password.text.toString()) &&
                password.text.toString().length > 7){
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
                    if (database.userDao().cekEmail(email.text.toString()).isNotEmpty()) {
                        Toast.makeText(applicationContext, "Email sudah terdaftar", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "isi Data Gagal: ", Toast.LENGTH_SHORT).show()
                    }
                }

            } else {
                if (password.text.toString() != confirmPassword.text.toString()) {
                    Toast.makeText(applicationContext, "Password tidak sesuai", Toast.LENGTH_SHORT).show()
                } else if (password.text.toString().length < 8) {
                    Toast.makeText(applicationContext, "Password kurang dari 8 karakter", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "isi semua data", Toast.LENGTH_SHORT).show()
                }
            }
        }

        buttonBackLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}