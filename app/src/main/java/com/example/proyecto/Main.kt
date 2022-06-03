package com.example.proyecto

import android.app.Application
import com.example.proyecto.utils.Prefs

class Main :Application() {

    companion object{
        lateinit var prefs:Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs=Prefs(applicationContext)
    }
}