package com.example.musicapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Classes.PlaylistModel
import com.example.musicapp.R
import com.example.musicapp.SongsActivity

class PlaylistAdapter(val context: Context, val arrPlaylist: ArrayList<PlaylistModel>) :
    RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val category = itemView.findViewById<TextView>(R.id.category)
        val cover = itemView.findViewById<ImageView>(R.id.cover)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.playlist_holder, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrPlaylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cover.setImageResource(arrPlaylist[position].cover)
        holder.category.text = arrPlaylist[position].category

        holder.cover.setOnClickListener(View.OnClickListener {
            var iSongs = Intent(context, SongsActivity::class.java)
            context.startActivity(iSongs)
        })

    }
}