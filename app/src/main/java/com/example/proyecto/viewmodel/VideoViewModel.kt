package com.example.proyecto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto.data.Music
import com.example.proyecto.data.Video
import com.example.proyecto.domain.data.network.Repo

class VideoViewModel :ViewModel(){
    val repo= Repo()
    fun fetchVideoData(): LiveData<MutableList<Video>> {
        val mutableData = MutableLiveData<MutableList<Video>>()
        repo.getVideoData().observeForever { videoList ->
            mutableData.value=videoList
        }
        return mutableData
    }
}