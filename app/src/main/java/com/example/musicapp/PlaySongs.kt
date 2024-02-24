package com.example.musicapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class PlaySongs : AppCompatActivity() {
    private val songList: ArrayList<String> = ArrayList(
        listOf(
            "song1",
            "song2",
            "song3",
            "song4",
            "song5",
            "song6",
            "song7",
            "song8",
            "song9",
            "song10",
            "song11",
            "song12",
            "song13"
        )
    )
    private val songNamesList: ArrayList<String> = ArrayList(
        listOf(
            "Aao Milo Chale",
            "Apna Har Din",
            "Deewangi Deewangi",
            "Gallan Goodiyaan",
            "Jab Tak",
            "Kaise Hua",
            "Kesariya",
            "Tum Se Hi",
            "Love You Zindagi",
            "Mast Magan",
            "Raatan Lambiyaan",
            "Tumhi Ho Bandhu",
            "Yeh Ishq Hai"
        )
    )
    var handler: Handler = Handler(Looper.getMainLooper())
    lateinit var seekBar: SeekBar
    lateinit var play: ImageView
    var position: Int = 0
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_songs)

        val playSongName: TextView = findViewById(R.id.playSongName)
        val playSongCover: ImageView = findViewById(R.id.playSongCover)
        seekBar = findViewById(R.id.seekBar)
        val previous: ImageView = findViewById(R.id.previous)
        play = findViewById(R.id.play)
        val next: ImageView = findViewById(R.id.next)

        position = intent.getIntExtra("position", 0)

        playSongName.text = songNamesList[position]
        val coverResourceId = resources.getIdentifier(songList[position], "drawable", packageName)
        playSongCover.setImageResource(coverResourceId)

        val songResourceId = resources.getIdentifier(songList[position], "raw", packageName)
        mediaPlayer = MediaPlayer.create(this, songResourceId)
        mediaPlayer?.start()
        seekBar.max = mediaPlayer.duration
        updateSeekBar()

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        mediaPlayer.setOnCompletionListener {
            mediaPlayer = MediaPlayer.create(this, songResourceId)
            play.setImageResource(R.drawable.pause)
        }

        //Click listeners
        play.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                play.setImageResource(R.drawable.play)
                mediaPlayer.pause()

            } else {
                play.setImageResource(R.drawable.pause)
                mediaPlayer.start()
            }
        }

        previous.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.release()
            if (position != 0) {
                position = position - 1
            } else {
                position = songList.size - 1
            }
            playSongName.text = songNamesList[position]
            val coverResourceId =
                resources.getIdentifier(songList[position], "drawable", packageName)
            playSongCover.setImageResource(coverResourceId)
            play.setImageResource(R.drawable.pause)

            val songResourceId = resources.getIdentifier(songList[position], "raw", packageName)
            mediaPlayer = MediaPlayer.create(this, songResourceId)
            mediaPlayer?.start()
            seekBar.progress = 0
            seekBar.max = mediaPlayer.duration
        }

        next.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.release()
            if (position != songList.size - 1) {
                position = position + 1
            } else {
                position = 0
            }
            playSongName.text = songNamesList[position]
            val coverResourceId =
                resources.getIdentifier(songList[position], "drawable", packageName)
            playSongCover.setImageResource(coverResourceId)
            play.setImageResource(R.drawable.pause)

            val songResourceId = resources.getIdentifier(songList[position], "raw", packageName)
            mediaPlayer = MediaPlayer.create(this, songResourceId)
            mediaPlayer?.start()
            seekBar.progress = 0
            seekBar.max = mediaPlayer.duration
        }

    }

    fun updateSeekBar() {
        handler.postDelayed({
            try {
                seekBar.progress = mediaPlayer.currentPosition
                if (mediaPlayer.currentPosition < mediaPlayer.duration) {
                    updateSeekBar()
                } else {
                    seekBar.progress = 0
                    mediaPlayer?.seekTo(0)
                    play.setImageResource(R.drawable.play)
                    updateSeekBar()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

}