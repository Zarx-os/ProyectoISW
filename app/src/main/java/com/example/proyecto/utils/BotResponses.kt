package com.example.proyecto.utils

import com.example.proyecto.utils.Constants.OPEN_GOOGLE
import com.example.proyecto.utils.Constants.OPEN_SEARCH

object BotResponses {
    fun basicResponses(_message:String):String{
        val random=(0..2).random()
        val message=_message.toLowerCase()

        return when{
            message.contains("Hello")->{
                when(random) {
                    0 -> "Hello there!"
                    1 -> "Bounjour"
                    2 -> "Boungiorno!"
                    else -> "error"
                }
            }
            message.contains("How are you?")->{
                when(random) {
                    0 -> "Me encuentro bien, gracias por preguntar!"
                    1 -> "Tengo hambre"
                    2 -> "Muy bien,que tal tu?"
                    else -> "error"
                }
            }
            message.contains("volado")->{
                var r=(0..1).random()
                var result=if(r==0)"cara" else "cruz"
                "Lazamos la moneda y lo que salio fue $result"
            }

            message.contains("time")->{
                Time.timeStamp()
            }
            message.contains("open") && message.contains("google")->{
                OPEN_GOOGLE
            }
            message.contains("search") ->{
                OPEN_SEARCH
            }
            else->{
                when(random){
                    0->"No te entiendo"
                    1->"Mmhh...."
                    2->"Pregunta otra cosa diferente"
                    else -> "error"
                }
            }
        }

    }

}