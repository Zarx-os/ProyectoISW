package com.example.proyecto.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.R
import com.example.proyecto.data.Video

class VideoAdapter(private val itemClickListener: OnVideoClickListener): RecyclerView.Adapter<VideoAdapter.ViewHolder>() {


    private var dataList = mutableListOf<Video>()

    fun setListData(data: MutableList<Video>) {
        dataList = data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VideoAdapter.ViewHolder {
        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.video_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: VideoAdapter.ViewHolder, i: Int) {
        val video = dataList[i]
        viewHolder.bindView(video)
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0) {
            return dataList.size
        } else {
            return 0
        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(video: Video) {

            var itemTitle: TextView = itemView.findViewById(R.id.txtTituloVideo)
            var itemImage: ImageView = itemView.findViewById(R.id.imgVideos)

            itemView.setOnClickListener {
                itemClickListener.onItemClick(itemView.context,video.videoId,video.title)
            }
            Glide.with(itemView.context).load(video.imageUrl).into(itemImage)
            itemTitle.text = video.title
        }
    }
    interface OnVideoClickListener{
        fun onItemClick(context: Context, id:String, title:String)
    }

}