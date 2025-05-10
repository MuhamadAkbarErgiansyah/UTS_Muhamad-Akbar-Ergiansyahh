package com.example.uts_apkbookingtiketbioskop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val inputEmail = findViewById<EditText>(R.id.colum_email)
        val inputPassword = findViewById<EditText>(R.id.colum_password)
        val btnRegister = findViewById<Button>(R.id.btn_register)
        val txtlogin = findViewById<TextView>(R.id.txt_login)

        // Simpan data di SharedPreferences
        val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val editor = sharedPref.edit()
                editor.putString(email, password)
                editor.apply()

                Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                finish()
            } else {
                Toast.makeText(this, "Kolom tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
        txtlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
    }
}
