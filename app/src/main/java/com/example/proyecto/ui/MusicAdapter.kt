package com.example.proyecto.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.R
import com.example.proyecto.data.Music
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class MusicAdapter(private val itemClickListener: OnMusicClickListener): RecyclerView.Adapter<MusicAdapter.ViewHolder>() {


    private var dataList = mutableListOf<Music>()

    fun setListData(data: MutableList<Music>) {
        dataList = data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MusicAdapter.ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.song_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: MusicAdapter.ViewHolder, i: Int) {
        val music = dataList[i]
        viewHolder.bindView(music)
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0) {
            return dataList.size
        } else {
            return 0
        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(music: Music) {

            var itemTitle: TextView = itemView.findViewById(R.id.item_song_title)
            var itemImage: ImageView = itemView.findViewById(R.id.item_song_image)
            var itemSubtitle: TextView = itemView.findViewById(R.id.item_song_detail)
            var itemSongUri: TextView = itemView.findViewById(R.id.txtSongUri)
            itemView.setOnClickListener {
                itemClickListener.onItemClick(itemView.context,music.mediaId)
            }
            Glide.with(itemView.context).load(music.imageUrl).into(itemImage)
            itemTitle.text = music.title
            itemSubtitle.text = music.subtitle
            itemSongUri.text=music.mediaId
        }
    }
    interface OnMusicClickListener{
        fun onItemClick(context: Context,name:String)
    }

}