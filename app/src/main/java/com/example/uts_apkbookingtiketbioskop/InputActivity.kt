package com.example.uts_apkbookingtiketbioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class InputActivity : AppCompatActivity() {

    private lateinit var txtJudulFilm: TextView
    private lateinit var txtDeskripsiFilm: TextView
    private lateinit var inputJadwal: EditText
    private lateinit var inputTiket: EditText
    private lateinit var inputKursi: EditText
    private lateinit var btnKonfirmasi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        txtJudulFilm = findViewById(R.id.txtJudulFilm)
        txtDeskripsiFilm = findViewById(R.id.txtDeskripsiFilm)
        inputJadwal = findViewById(R.id.inputJadwal)
        inputTiket = findViewById(R.id.inputTiket)
        inputKursi = findViewById(R.id.inputKursi)
        btnKonfirmasi = findViewById(R.id.btnKonfirmasi)

        // ambil data dari MainActivity
        val judul = intent.getStringExtra("judul")
        val deskripsi = intent.getStringExtra("deskripsi")

        txtJudulFilm.text = judul
        txtDeskripsiFilm.text = deskripsi

        btnKonfirmasi.setOnClickListener {
            val jadwal = inputJadwal.text.toString()
            val tiket = inputTiket.text.toString()
            val kursi = inputKursi.text.toString()

            if (jadwal.isEmpty() || tiket.isEmpty() || kursi.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ListChatActivity::class.java)
            intent.putExtra("judul", judul)
            intent.putExtra("jadwal", jadwal)
            intent.putExtra("tiket", tiket)
            intent.putExtra("kursi", kursi)
            startActivity(intent)
        }
    }
}