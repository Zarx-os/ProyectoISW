package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.proyecto.ui.ChatBot


class MainActivity : AppCompatActivity() {

    private lateinit var LButton1: LinearLayout
    private lateinit var LButton2: LinearLayout
    private lateinit var LButton3: LinearLayout
    private lateinit var LButton4: LinearLayout
    private lateinit var LButton5: LinearLayout
    private lateinit var LButton6: LinearLayout
    private lateinit var LButton7: Button
    private lateinit var IButton: ImageView
    private lateinit var txtBuho: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LButton1 = findViewById(R.id.LButton1)
        LButton2 = findViewById(R.id.LButton2)
        LButton3 = findViewById(R.id.LButton3)
        LButton4 = findViewById(R.id.LButton4)
        LButton5 = findViewById(R.id.LButton5)
        LButton6 = findViewById(R.id.LButton6)
        LButton7 = findViewById(R.id.LButton7)
        IButton = findViewById(R.id.imgBuho)
        txtBuho = findViewById(R.id.txtBuho)


        txtBuho.text = "Espero que tengas un lindo dia"

        IButton.setOnClickListener {
            val random = (0..2).random()
            when (random) {
                0 -> {
                    txtBuho.text = "Es un lindo dia para salir a caminar"
                }
                1 -> {
                    txtBuho.text = "No olvides saludar a tus amigos, son muy importante"
                }
                2 -> {
                    txtBuho.text = "Eres alguien increible"
                }
                else -> {
                    txtBuho.text = "Me quede sin frases, perdoname"
                }
            }
        }

        LButton1.setOnClickListener {
            val intent = Intent(this, ChatBot::class.java)
            startActivity(intent)
        }
        LButton2.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }


        LButton3.setOnClickListener {

            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            //Toast.makeText(this,"Este boton aun no esta programado Juega",Toast.LENGTH_SHORT).show()

        }

        LButton4.setOnClickListener {
            val intent = Intent(this, Ayuda::class.java)
            startActivity(intent)
        }


        LButton5.setOnClickListener {
            val intent = Intent(this, Test::class.java)
            startActivity(intent)
        }

        LButton6.setOnClickListener {

            Toast.makeText(this,"Este boton aun no esta programado Entretenimiento",Toast.LENGTH_SHORT).show()
        }

        LButton7.setOnClickListener {
            Toast.makeText(this,"Este boton aun no esta programado MODULO",Toast.LENGTH_SHORT).show()
        }
        }




}