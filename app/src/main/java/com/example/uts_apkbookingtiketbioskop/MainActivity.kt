package com.example.uts_apkbookingtiketbioskop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var listViewFilm: ListView
    private lateinit var listFilm: ArrayList<Film>
    private lateinit var adapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewFilm = findViewById(R.id.listViewFilm)
        listFilm = ArrayList()

        listFilm.add(Film(R.drawable.avengers, "Avengers: Endgame", "Film aksi superhero Marvel."))
        listFilm.add(Film(R.drawable.spiderman, "Spider-Man No Way Home", "Petualangan Spider-Man di multiverse."))
        listFilm.add(Film(R.drawable.batman, "The Batman", "Aksi Batman melawan kejahatan Gotham."))
        listFilm.add(Film(R.drawable.joker, "Joker", "Kisah kelam di balik sosok Joker."))

        adapter = FilmAdapter(this, listFilm)
        listViewFilm.adapter = adapter

        listViewFilm.setOnItemClickListener { _, _, position, _ ->
            val selectedFilm = listFilm[position]
            val intent = Intent(this, InputActivity::class.java)
            intent.putExtra("judul", selectedFilm.judul)
            intent.putExtra("deskripsi", selectedFilm.deskripsi)
            startActivity(intent)
        }
    }
}
