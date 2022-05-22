package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.proyecto.ui.ChatBot


class MainActivity : AppCompatActivity() {

    private lateinit var LButton1:LinearLayout
    private lateinit var LButton2:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LButton1=findViewById(R.id.LButtton1)
        LButton2=findViewById(R.id.LButtton2)


        LButton1.setOnClickListener {
            val intent=Intent(this, ChatBot::class.java)
            startActivity(intent)
        }
        LButton2.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Mensaje")
            builder.setMessage("Mensaje de prueba")
            builder.setPositiveButton("yes", { dialog, id ->
                dialog.cancel()
            })
            builder.setNegativeButton("No", { dialog, id ->
                dialog.cancel()
            })
            var alert = builder.create()
            alert.show()
        }

    }


}