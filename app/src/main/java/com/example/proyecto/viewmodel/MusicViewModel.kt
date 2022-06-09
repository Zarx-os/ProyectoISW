package com.example.proyecto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto.data.Music
import com.example.proyecto.domain.data.network.Repo

class MusicViewModel:ViewModel() {

    val repo= Repo()
    fun fetchMusicData(): LiveData<MutableList<Music>> {
        val mutableData = MutableLiveData<MutableList<Music>>()
        repo.getMusicData().observeForever { musicList ->
            mutableData.value=musicList
        }
        return mutableData
    }

}