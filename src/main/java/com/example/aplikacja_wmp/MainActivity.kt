package com.example.aplikacja_wmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {

            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty()) {
                etUsername.error = "Podaj login"
                etUsername.requestFocus()
            } else if (password.isEmpty()) {
                etPassword.error = "Wprowadz haslo"
                etPassword.requestFocus()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}