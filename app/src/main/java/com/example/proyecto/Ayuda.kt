package com.example.proyecto

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Ayuda : AppCompatActivity() {
    lateinit var btnCall:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)
        btnCall=findViewById(R.id.btnCall)

        btnCall.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Contactos")
                //builder.setMessage("Aqui encontraras una lista de profesionales con los cuales puedes hablar")
                .setItems(R.array.contactos_list,
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(this, "Se presiono ${dialog.toString()} y $which", Toast.LENGTH_SHORT).show()
                    }
                )
            val alert = builder.create()
            alert.show()
        }

    }
}