package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.proyecto.Main.Companion.prefs
import org.w3c.dom.Text

class Profile : AppCompatActivity() {
    lateinit var btnRegresar:Button
    lateinit var txtNombre:TextView
    lateinit var txtEdad:TextView
    lateinit var txtGenero:TextView
    lateinit var txtPad:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnRegresar = findViewById(R.id.btnRegresar)
        txtNombre=findViewById(R.id.txtNombreUser)
        txtEdad=findViewById(R.id.txtEdad)
        txtGenero=findViewById(R.id.txtGenero)
        txtPad=findViewById(R.id.txtPad)

        txtEdad.text=prefs.getEdad().toString()
        txtNombre.text= prefs.getNom()
        txtGenero.text= prefs.getSexo()
        if(prefs.getTrans()==1){
            txtPad.text="Ansiedad"
        }else if(prefs.getTrans()==2){
            txtPad.text="Depresion"
        }else txtPad.text="SANO"



        btnRegresar.setOnClickListener{
            finish()
        }

    }

}