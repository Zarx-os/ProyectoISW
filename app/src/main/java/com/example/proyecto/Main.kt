package com.example.proyecto

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder
import com.example.proyecto.utils.Prefs

class Main :Application() {

    companion object{
        lateinit var prefs:Prefs
       /* var musicService:MusicService?=null
        const val CHANNEL_ID="channel1"
        const val PLAY="play"
        const val NEXT="next"
        const val PREVIOUS="previous"
        const val EXIT="exit"*/
    }

    override fun onCreate() {
        super.onCreate()
        prefs=Prefs(applicationContext)/*
       if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val notificationChannel=NotificationChannel(CHANNEL_ID,"Ahora esta sonando",
                NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.description="Este es un importante channel para mostrar una cancion!!"
            val notificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }*/
    }
}