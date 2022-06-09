package com.example.proyecto.fragments.entretenimiento

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.PlayerActivity
import com.example.proyecto.R
import com.example.proyecto.ui.MusicAdapter
import com.example.proyecto.ui.VideoAdapter
import com.example.proyecto.viewmodel.MusicViewModel
import com.example.proyecto.viewmodel.VideoViewModel
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.exoplayer2.MediaItem
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView


class VideoFragment : Fragment(),VideoAdapter.OnVideoClickListener {

    private val viewModel by lazy { ViewModelProvider(this).get(VideoViewModel::class.java) }
    private var adapter = VideoAdapter(this)

    lateinit var recyclerView: RecyclerView
    lateinit var containerVideos:ShimmerFrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        recyclerView = view.findViewById(R.id.rvVideo)
        containerVideos=view.findViewById(R.id.shimmer_view_container_videos)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        observeData()
        return view
    }

    fun observeData() {
        containerVideos.startShimmer()
        viewModel.fetchVideoData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            containerVideos.stopShimmer()
            containerVideos.visibility=View.GONE
            adapter.notifyDataSetChanged()
        })


    }

    override fun onItemClick(context: Context, id: String,title:String) {
        val i = Intent(context,PlayerActivity::class.java)
        i.putExtra("video_id",id)
        i.putExtra("video_title",title)
        startActivity(i)
    }


}