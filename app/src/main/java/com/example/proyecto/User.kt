package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.proyecto.Main.Companion.prefs

class User : AppCompatActivity() {
    lateinit var edtNombre: EditText
    lateinit var edtNumero: EditText
    lateinit var btnUsuario: Button
    lateinit var spSexo: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        edtNombre = findViewById(R.id.edtNombre)
        edtNumero = findViewById(R.id.edtNumero)
        btnUsuario = findViewById(R.id.btnUsuario)
        spSexo = findViewById(R.id.spSexo)

        btnUsuario.setOnClickListener {

            if (edtNombre.text.isEmpty() || edtNumero.text.isEmpty() || (edtNombre.text.isEmpty() && edtNumero.text.isEmpty())) {
                Toast.makeText(this, "Debes llenar ambos campos para continuar", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (spSexo.selectedItem.equals("Seleccionar...")) {
                    Toast.makeText(
                        this,
                        "Debes seleccionar una opcion valida en Sexo",
                        Toast.LENGTH_SHORT
                    )
                } else {
                    prefs.saveNom(edtNombre.text.toString())
                    prefs.saveEdad(Integer.parseInt(edtNumero.text.toString()))
                    prefs.saveSexo(spSexo.selectedItem.toString())
                    startActivity(Intent(this, Test::class.java))
                    finish()
                }
            }
        }

    }
}