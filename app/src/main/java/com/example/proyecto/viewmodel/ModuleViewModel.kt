package com.example.proyecto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyecto.data.Modulo
import com.example.proyecto.domain.data.network.Repo

class ModuleViewModel : ViewModel() {

    val repo= Repo()
    fun fetchModuleData(): LiveData<MutableList<Modulo>> {
        val mutableData = MutableLiveData<MutableList<Modulo>>()
        repo.getModuleData().observeForever { moduleList ->
            mutableData.value=moduleList
        }
        return mutableData
    }
}