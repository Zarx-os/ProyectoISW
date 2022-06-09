package com.example.proyecto

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.proyecto.Main.Companion.prefs
import com.google.firebase.firestore.FirebaseFirestore

class MActivity() : AppCompatActivity() {
    lateinit var txtModuloTitle:TextView
    lateinit var txtModulo: TextView
    lateinit var vdVideo: EditText
    lateinit var btnModuloT: Button
    var dbFirebase = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mactivity)
        txtModuloTitle=findViewById(R.id.txtModuloTitle)
        txtModulo = findViewById(R.id.txtModulo)
        vdVideo = findViewById(R.id.vdVideo)
        btnModuloT = findViewById(R.id.btnModuloT)



        if (intent.extras != null) {
            dbFirebase.collection("informacion")
                .document(intent.getStringExtra("titulo").toString().lowercase()).get()
                .addOnSuccessListener {
                    txtModulo.text = it.get("modulo").toString()
                    txtModuloTitle.text=intent.getStringExtra("titulo")
                }
        }

        btnModuloT.setOnClickListener {
            var cont: Int = prefs.getMUser()

            if (cont < prefs.getM()) {
                cont++
                prefs.saveMUser(cont)
                Toast.makeText(this, "Felicidades, terminaste un modulo", Toast.LENGTH_LONG)
                    .show()
                finish()
            } else {

                Toast.makeText(
                    this,
                    "Ya terminaste todos los modulos, espera a que haya mas",
                    Toast.LENGTH_LONG
                ).show()
                finish()

            }
        }
    }
}