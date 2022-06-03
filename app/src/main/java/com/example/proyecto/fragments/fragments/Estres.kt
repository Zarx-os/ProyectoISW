package com.example.proyecto.fragments.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyecto.Main
import com.example.proyecto.R

class Estres : Fragment() {

    lateinit var btnDepresion: Button
    lateinit var edtPregunta1: EditText
    lateinit var edtPregunta2: EditText
    lateinit var edtPregunta3: EditText
    lateinit var edtPregunta4: EditText
    lateinit var edtPregunta5: EditText
    lateinit var edtPregunta6: EditText
    lateinit var edtPregunta7: EditText
    lateinit var edtPregunta8: EditText
    lateinit var edtPregunta9: EditText
    lateinit var edtPregunta10: EditText
    lateinit var edtPregunta11: EditText
    lateinit var edtPregunta12: EditText
    var sum:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_estres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDepresion = view.findViewById(R.id.btnDepresion)
        edtPregunta1= view.findViewById(R.id.edtPreguntaD1)
        edtPregunta2= view.findViewById(R.id.edtPreguntaD2)
        edtPregunta3= view.findViewById(R.id.edtPreguntaD3)
        edtPregunta4= view.findViewById(R.id.edtPreguntaD4)
        edtPregunta5= view.findViewById(R.id.edtPreguntaD5)
        edtPregunta6= view.findViewById(R.id.edtPreguntaD6)
        edtPregunta7= view.findViewById(R.id.edtPreguntaD7)
        edtPregunta8= view.findViewById(R.id.edtPreguntaD8)
        edtPregunta9= view.findViewById(R.id.edtPreguntaD9)
        edtPregunta10= view.findViewById(R.id.edtPreguntaD10)
        edtPregunta11= view.findViewById(R.id.edtPreguntaD11)
        edtPregunta12= view.findViewById(R.id.edtPreguntaD12)


        btnDepresion.setOnClickListener {

            if((edtPregunta1.text.isEmpty() &&
                        edtPregunta2.text.isEmpty()||
                        edtPregunta3.text.isEmpty()||
                        edtPregunta4.text.isEmpty()||
                        edtPregunta5.text.isEmpty()||
                        edtPregunta6.text.isEmpty()||
                        edtPregunta7.text.isEmpty()||
                        edtPregunta8.text.isEmpty()||
                        edtPregunta9.text.isEmpty()||
                        edtPregunta10.text.isEmpty()||
                        edtPregunta11.text.isEmpty()||
                        edtPregunta12.text.isEmpty())){
                Toast.makeText(this.context,"No debes dejar vacio ningun campo", Toast.LENGTH_SHORT).show()
            }else if((getVal(edtPregunta1.text) &&
                        getVal(edtPregunta2.text)&&
                        getVal(edtPregunta3.text)&&
                        getVal(edtPregunta4.text)&&
                        getVal(edtPregunta5.text)&&
                        getVal(edtPregunta6.text)&&
                        getVal(edtPregunta7.text)&&
                        getVal(edtPregunta8.text)&&
                        getVal(edtPregunta9.text)&&
                        getVal(edtPregunta10.text)&&
                        getVal(edtPregunta11.text)&&
                        getVal(edtPregunta12.text))){
                edtPregunta1.isEnabled = false
                edtPregunta2.isEnabled = false
                edtPregunta3.isEnabled = false
                edtPregunta4.isEnabled = false
                edtPregunta5.isEnabled = false
                edtPregunta6.isEnabled = false
                edtPregunta7.isEnabled = false
                edtPregunta8.isEnabled = false
                edtPregunta9.isEnabled = false
                edtPregunta10.isEnabled = false
                edtPregunta11.isEnabled = false
                edtPregunta12.isEnabled = false



                sum=Integer.parseInt(edtPregunta1.text.toString()) +
                        Integer.parseInt(edtPregunta2.text.toString()) +
                        Integer.parseInt(edtPregunta3.text.toString()) +
                        Integer.parseInt(edtPregunta4.text.toString()) +
                        Integer.parseInt(edtPregunta5.text.toString()) +
                        Integer.parseInt(edtPregunta6.text.toString()) +
                        Integer.parseInt(edtPregunta7.text.toString()) +
                        Integer.parseInt(edtPregunta8.text.toString()) +
                        Integer.parseInt(edtPregunta9.text.toString()) +
                        Integer.parseInt(edtPregunta10.text.toString()) +
                        Integer.parseInt(edtPregunta11.text.toString()) +
                        Integer.parseInt(edtPregunta12.text.toString())


                if(Main.prefs.getUser()==0){
                    Main.prefs.saveVal(1)
                }else if(Main.prefs.getUser()==1){
                    activity?.finish()
                }

            }
            else Toast.makeText(this.context,"Recuerda que cada solo es de 0 a 3", Toast.LENGTH_SHORT).show()



        }

    }

    fun getVal(number: Editable):Boolean{
        if(Integer.parseInt(number.toString())<4 && Integer.parseInt(number.toString())>=0)
            return true
        else return false
    }

    fun getRes():Int{
        return sum
    }



}