package com.example.uts_apkbookingtiketbioskop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListChatActivity : AppCompatActivity() {

    private lateinit var listChat: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chat)

        listChat = findViewById(R.id.listChat)

        val judul = intent.getStringExtra("judul")
        val jadwal = intent.getStringExtra("jadwal")
        val tiket = intent.getStringExtra("tiket")
        val kursi = intent.getStringExtra("kursi")

        val pesanChat = ArrayList<String>()
        pesanChat.add("Film: $judul")
        pesanChat.add("Jadwal: $jadwal")
        pesanChat.add("Jumlah tiket: $tiket")
        pesanChat.add("Kursi: $kursi")
        pesanChat.add("Pesanan berhasil disimpan!")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pesanChat)
        listChat.adapter = adapter
    }
}