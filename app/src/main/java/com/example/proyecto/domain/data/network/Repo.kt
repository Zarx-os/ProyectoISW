package com.example.proyecto.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.proyecto.data.Modulo
import com.example.proyecto.data.Music
import com.example.proyecto.data.Video
import com.google.firebase.firestore.FirebaseFirestore

class Repo {
    fun getModuleData(): LiveData<MutableList<Modulo>> {
        val mutableData = MutableLiveData<MutableList<Modulo>>()
        FirebaseFirestore.getInstance().collection("Modulos").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Modulo>()
            for (document in result) {
                val imageUrl = document.getString("imageUrl")
                val title = document.getString("title")
                val des = document.getString("des")
                val modulo = Modulo(title!!, imageUrl!!, des!!)
                listData.add(modulo)
            }
            mutableData.value = listData
        }
        return mutableData
    }

    fun getMusicData(): LiveData<MutableList<Music>> {
        val mutableData = MutableLiveData<MutableList<Music>>()
        FirebaseFirestore.getInstance().collection("songs").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Music>()
            for (document in result) {
                val imageUrl = document.getString("imageUrl")
                val mediaId = document.getString("mediaId")
                val songUrl = document.getString("songUrl")
                val subtitle = document.getString("subtitle")
                val title = document.getString("title")
                val musica = Music(imageUrl!!, mediaId!!, songUrl!!, subtitle!!, title!!)
                listData.add(musica)
            }
            mutableData.value = listData
        }
        return mutableData
    }

    fun getVideoData(): LiveData<MutableList<Video>> {
        val mutableData = MutableLiveData<MutableList<Video>>()
        FirebaseFirestore.getInstance().collection("videos").get().addOnSuccessListener { result ->
            val listData = mutableListOf<Video>()
            for (document in result) {
                val imageUrl = document.getString("imageUrl")
                val mediaId = document.getString("mediaId")
                val videoId = document.getString("videoId")
                //val subtitle = document.getString("subtitle")
                val title = document.getString("title")
                val video = Video(imageUrl!!, mediaId!!, videoId!!, title!!)
                listData.add(video)
            }
            mutableData.value = listData
        }
        return mutableData
    }



}