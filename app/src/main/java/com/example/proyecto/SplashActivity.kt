package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyecto.Main.Companion.prefs

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val usuario:Int = prefs.getUser()
        if (usuario==0){
        startActivity(Intent(this, User::class.java))
        finish()
        }
        else if(usuario==1) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}