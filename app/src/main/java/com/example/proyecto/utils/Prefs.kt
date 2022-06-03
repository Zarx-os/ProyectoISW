package com.example.proyecto.utils

import android.content.Context

class Prefs(val context: Context) {
    val SHARED_NAME="MyDB"
    val SHARED_USUARIO="usuario"
    val SHARED_TRANS="transtorno"
    val SHARED_NOM="nombre"
    val SHARED_EDAD="edad"
    val SHARED_SEXO="sexo"
    val SHARED_VAL="validacion"


    val storage=context.getSharedPreferences(SHARED_NAME,0)

    fun saveUser(number:Int){
        storage.edit().putInt(SHARED_USUARIO,number).commit()
    }

    fun saveTrans(number:Int){
        storage.edit().putInt(SHARED_TRANS,number).commit()
    }
    fun saveNom(name:String){
        storage.edit().putString(SHARED_NOM,name).commit()
    }


    fun saveEdad(number:Int){
        storage.edit().putInt(SHARED_EDAD,number).commit()
    }

    fun saveSexo(name:String){
        storage.edit().putString(SHARED_SEXO,name).commit()
    }

    fun getSexo():String{
        return storage.getString(SHARED_SEXO,"")!!
    }

    fun saveVal(number:Int){
        storage.edit().putInt(SHARED_VAL,number).commit()
    }

    fun getVal():Int{
        return storage.getInt(SHARED_VAL,0)!!
    }

    fun getEdad():Int{
        return storage.getInt(SHARED_EDAD,0)!!
    }
    fun getNom():String{
        return storage.getString(SHARED_NOM,"")!!
    }
    fun getUser():Int{
        return storage.getInt(SHARED_USUARIO,0)!!
    }

    fun getTrans():Int{
        return storage.getInt(SHARED_TRANS,0)!!
    }

}