package com.example.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.proyecto.Main.Companion.prefs
import com.example.proyecto.fragments.fragments.Ansiedad
import com.example.proyecto.fragments.fragments.Estres
import com.example.proyecto.fragments.fragments.Inicio

class Test : AppCompatActivity() {
    private lateinit var btnFrag: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        btnFrag = findViewById(R.id.btnFrag)

        val fragmentEstres = Estres()
        val fragmentAnsiedad = Ansiedad()
        val fragmentInicio = Inicio()

        val usuario: Int = prefs.getUser()
        val transtorno: Int = prefs.getTrans()

        if(usuario==0){
            var cont: Int = 0
            var params:ConstraintLayout.LayoutParams =  btnFrag.layoutParams as ConstraintLayout.LayoutParams
            supportFragmentManager.beginTransaction().replace(R.id.contenedor, fragmentInicio).commit()
            btnFrag.setOnClickListener {

                when (cont) {
                    0 -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.contenedor, fragmentAnsiedad).commit()
                        btnFrag.text="Siguente"
                        params.width=100
                        btnFrag.animate().x(500F).y(1200F).setDuration(1500).start()
                        cont++
                    }
                    1 -> {
                        if(prefs.getVal()==1){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.contenedor, fragmentEstres).commit()
                            btnFrag.text="Finalizar"
                            cont++
                            prefs.saveVal(0)
                        }else if(prefs.getVal()==0){
                            Toast.makeText(this,"Recuerda que debes terminar el formulario",Toast.LENGTH_SHORT).show()
                        }
                    }
                    2 -> {
                        if(prefs.getVal()==1){
                            if(fragmentAnsiedad.getSum1()>fragmentEstres.getRes()){
                                prefs.saveTrans(1)
                            }else if(fragmentEstres.getRes()>fragmentAnsiedad.getSum1()){
                                prefs.saveTrans(2)
                            }else prefs.saveTrans(3)
                            prefs.saveUser(1)
                            prefs.saveVal(0)
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }else if(prefs.getVal()==0){
                            Toast.makeText(this,"Recuerda que debes terminar el formulario",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }else if(usuario==1){

            btnFrag.visibility=View.GONE
            if(transtorno==1){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, fragmentAnsiedad).commit()
            }else if(transtorno==2){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, fragmentEstres).commit()
            }
        }
    }

}

