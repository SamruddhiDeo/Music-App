package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Adapters.PlaylistAdapter
import com.example.musicapp.Adapters.SongsAdapter
import com.example.musicapp.Classes.SongsModel
import com.example.musicapp.R.id.songsRecyclerView
import com.example.musicapp.databinding.ActivityMainBinding

class SongsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        val songsRecyclerView: RecyclerView = findViewById<RecyclerView>(songsRecyclerView)

        var arrSongs = ArrayList<SongsModel>()

        arrSongs.add(SongsModel(R.drawable.song1, "Aao Milo Chale"))
        arrSongs.add(SongsModel(R.drawable.song2, "Apna Har Din"))
        arrSongs.add(SongsModel(R.drawable.song3, "Deewangi Deewangi"))
        arrSongs.add(SongsModel(R.drawable.song4, "Gallan Goodiyaan"))
        arrSongs.add(SongsModel(R.drawable.song5, "Jab Tak"))
        arrSongs.add(SongsModel(R.drawable.song6, "Kaise Hua"))
        arrSongs.add(SongsModel(R.drawable.song7, "Kesariya"))
        arrSongs.add(SongsModel(R.drawable.song8, "Tum Se Hi"))
        arrSongs.add(SongsModel(R.drawable.song9, "Love You Zindagi"))
        arrSongs.add(SongsModel(R.drawable.song10, "Mast Magan"))
        arrSongs.add(SongsModel(R.drawable.song11, "Raatan Lambiyaan"))
        arrSongs.add(SongsModel(R.drawable.song12, "Tumhi Ho Bandhu"))
        arrSongs.add(SongsModel(R.drawable.song13, "Yeh Ishq Hai"))

        songsRecyclerView.layoutManager = LinearLayoutManager(this)
        val songsAdapter = SongsAdapter(this, arrSongs)
        songsRecyclerView.adapter = songsAdapter

    }
}