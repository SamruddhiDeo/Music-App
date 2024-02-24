package com.example.musicapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Classes.SongsModel
import com.example.musicapp.PlaySongs
import com.example.musicapp.R

class SongsAdapter(val context: Context, val arrSongs: ArrayList<SongsModel>) :
    RecyclerView.Adapter<SongsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val songName = itemView.findViewById<TextView>(R.id.songName)
        val songCover = itemView.findViewById<ImageView>(R.id.songCover)
        val playBtn = itemView.findViewById<ImageView>(R.id.playBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.songs_holder, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrSongs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.songCover.setImageResource(arrSongs[position].songCover)
        holder.songName.text = arrSongs[position].songName

        holder.playBtn.setOnClickListener {
            var iPlaySong = Intent(context, PlaySongs::class.java)
            iPlaySong.putExtra("position", position)
            context.startActivity(iPlaySong)
        }
    }
}