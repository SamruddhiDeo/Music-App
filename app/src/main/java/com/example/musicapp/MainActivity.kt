package com.example.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicapp.Adapters.PlaylistAdapter
import com.example.musicapp.Classes.PlaylistModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playlistRecyclerView: RecyclerView = findViewById(R.id.playlistRecyclerView)

        var arrPlaylist = ArrayList<PlaylistModel>()

        arrPlaylist.add(PlaylistModel(R.drawable.chill_vibes, "Chill Vibes"))
        arrPlaylist.add(PlaylistModel(R.drawable.party, "Party Songs"))
        arrPlaylist.add(PlaylistModel(R.drawable.road_trips, "Road Trips"))
        arrPlaylist.add(PlaylistModel(R.drawable.melody, "Melody"))
        arrPlaylist.add(PlaylistModel(R.drawable.lonely, "Lonely Melodies"))
        arrPlaylist.add(PlaylistModel(R.drawable.romance, "Romance"))

        playlistRecyclerView.layoutManager = GridLayoutManager(this, 2)
        val playlistAdapter = PlaylistAdapter(this, arrPlaylist)
        playlistRecyclerView.adapter = playlistAdapter

    }
}