package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.proyecto.databinding.ActivityPlayerBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class PlayerActivity : YouTubeBaseActivity() {
    private val keyYT = "AIzaSyDH5j2yFowG0VbJajwdbAQ5iN3iKufuU1I"
    private var _binding:ActivityPlayerBinding?=null
    private val binding get() = _binding!!
    private var youTubePlayer:YouTubePlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val videoId=intent.getStringExtra("video_id")
        val videoTitle=intent.getStringExtra("video_title")
        binding.txtPlayerVideoTitulo.text=videoTitle
        binding.ytPlayerView.initialize(keyYT,object :YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                youTubePlayer=p1
                youTubePlayer?.loadVideo(videoId)
                youTubePlayer?.play()
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Snackbar.make(binding.root,"Fallo al inicializay Youtube",Snackbar.LENGTH_LONG).show()
            }
        })
    }
}