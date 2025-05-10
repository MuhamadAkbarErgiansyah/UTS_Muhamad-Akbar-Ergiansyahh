package com.example.uts_apkbookingtiketbioskop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.ArrayList

class FilmAdapter(private val context: Context, private val listFilm: ArrayList<Film>) : BaseAdapter() {

    override fun getCount(): Int = listFilm.size

    override fun getItem(position: Int): Any = listFilm[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, parent, false)
            holder = ViewHolder(
                view.findViewById(R.id.imgFilm),
                view.findViewById(R.id.txtJudul),
                view.findViewById(R.id.txtDeskripsi),
                view.findViewById(R.id.btnPesan)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val film = listFilm[position]

        holder.imgFilm.setImageResource(film.gambar)
        holder.txtJudul.text = film.judul
        holder.txtDeskripsi.text = film.deskripsi

        holder.btnPesan.setOnClickListener {
            val intent = Intent(context, InputActivity::class.java)
            intent.putExtra("judul", film.judul)
            intent.putExtra("deskripsi", film.deskripsi)
            context.startActivity(intent)
        }

        return view
    }

    private data class ViewHolder(
        val imgFilm: ImageView,
        val txtJudul: TextView,
        val txtDeskripsi: TextView,
        val btnPesan: Button
    )
}