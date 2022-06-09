package com.example.proyecto.fragments.entretenimiento

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R
import com.example.proyecto.ui.MusicAdapter
import com.example.proyecto.viewmodel.MusicViewModel
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerControlView


class MusicFragment : Fragment(), MusicAdapter.OnMusicClickListener{

    private val viewModel by lazy { ViewModelProvider(this).get(MusicViewModel::class.java) }
    private var adapter = MusicAdapter(this)

    lateinit var player: ExoPlayer
    lateinit var playerControlView: PlayerControlView
    lateinit var recyclerView: RecyclerView
    lateinit var containerSongs: ShimmerFrameLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_music, container, false)
        recyclerView = view.findViewById(R.id.rvSongs)
        playerControlView = view.findViewById(R.id.pcView)
        containerSongs = view.findViewById(R.id.shimmer_view_container_songs)
        player = ExoPlayer.Builder(view.context).build()
        playerControlView.player = player
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        observeData()
        player.repeatMode = Player.REPEAT_MODE_ALL
        return view
    }


    fun observeData() {
        containerSongs.startShimmer()
        viewModel.fetchMusicData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            containerSongs.stopShimmer()
            containerSongs.visibility = View.GONE
            it.map { musica ->
                player.addMediaItem(
                    MediaItem.Builder().setUri((musica.songUrl).toUri()).setMediaId(musica.mediaId)
                        .build()
                )
            }
            adapter.notifyDataSetChanged()
        })


    }

    override fun onItemClick(context: Context, name: String) {
        //Toast.makeText(context,"Se esta reproduciendo $name",Toast.LENGTH_SHORT).show()
        player.prepare()
        player.seekTo(name.toInt(), C.TIME_UNSET)
        player.playWhenReady=true
    }

}