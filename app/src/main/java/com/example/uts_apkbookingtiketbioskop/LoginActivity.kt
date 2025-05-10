package com.example.uts_apkbookingtiketbioskop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.colum_email)
        val passwordInput = findViewById<EditText>(R.id.colum_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        val txtRegister = findViewById<TextView>(R.id.txt_up)

        // akses SharedPreferences
        val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            // cek akun dummy bawaan
            val dummyAccounts = mapOf(
                "admin@gmail.com" to "admin123",
                "user@gmail.com" to "user123"
            )

            val savedPassword = sharedPref.getString(email, null) ?: dummyAccounts[email]

            if (savedPassword != null && savedPassword == password) {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Login gagal! Periksa email atau password.", Toast.LENGTH_SHORT).show()
            }
        }

        txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_out_right)
        }
    }
}
