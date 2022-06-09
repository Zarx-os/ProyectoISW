package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.proyecto.Main.Companion.prefs
import org.w3c.dom.Text

class Profile : AppCompatActivity() {
    lateinit var btnRegresar: Button
    lateinit var pbModulos: ProgressBar
    lateinit var txtNombre: TextView
    lateinit var txtEdad: TextView
    lateinit var txtGenero: TextView
    lateinit var txtPad: TextView
    lateinit var txtnoModulos: TextView
    lateinit var txtporcentaje: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnRegresar = findViewById(R.id.btnRegresar)
        txtNombre = findViewById(R.id.txtNombreUser)
        txtEdad = findViewById(R.id.txtEdad)
        txtGenero = findViewById(R.id.txtGenero)
        txtPad = findViewById(R.id.txtPad)
        txtnoModulos = findViewById(R.id.txtnoMod)
        txtporcentaje = findViewById(R.id.txtporcentaje)
        pbModulos = findViewById(R.id.pbModulos)

        txtEdad.text = prefs.getEdad().toString()
        txtNombre.text = prefs.getNom()
        txtGenero.text = prefs.getSexo()
        if (prefs.getTrans() == 1) {
            txtPad.text = "Ansiedad"
        } else if (prefs.getTrans() == 2) {
            txtPad.text = "Depresion"
        } else txtPad.text = "SANO"

        if(prefs.getM() == 0) {
            Toast.makeText(this,"Por favor ingresa a MODULOS DE AYUDA para actualizar la informacion",Toast.LENGTH_LONG).show()
        }else{
            txtnoModulos.text = prefs.getMUser().toString() + "/" + prefs.getM().toString()
            pbModulos.progress = ((prefs.getMUser().toDouble() / prefs.getM())* 100).toInt()
            txtporcentaje.text = ((prefs.getMUser().toDouble() / prefs.getM()) * 100.0).toString() + "%"
        }

        btnRegresar.setOnClickListener {
            finish()
        }

    }

}