package com.example.proyecto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var atg:Animation
    private lateinit var btnImagen1:Button
    private lateinit var txtHelp:TextView
    private lateinit var txtNo:TextView

    private lateinit var imgMari:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        atg=AnimationUtils.loadAnimation(this,R.anim.atg)
        imgMari=findViewById(R.id.imgMari)
        txtHelp=findViewById(R.id.txtHelp)
        txtNo=findViewById(R.id.txtMsg)
        btnImagen1= findViewById(R.id.btnMensaje)

        imgMari.startAnimation(atg);

    }
}