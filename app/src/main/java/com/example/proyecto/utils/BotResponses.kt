package com.example.proyecto.utils

import com.example.proyecto.utils.Constants.OPEN_GOOGLE
import com.example.proyecto.utils.Constants.OPEN_SEARCH

object BotResponses {
    fun basicResponses(_message:String):String{
        val random=(0..2).random()
        val message=_message.lowercase()

        return when{
            message.contains("hola")->{
                when(random) {
                    0 -> "Hello there!"
                    1 -> "Bounjour"
                    2 -> "Boungiorno!"
                    else -> "error"
                }
            }
            //Como te encuentras
            message.contains("cómo estás?")||message.contains("cómo te encuentras?")->{
                when(random) {
                    0 -> "Me encuentro bien, gracias por preguntar!"
                    1 -> "Tengo hambre"
                    2 -> "Muy bien,que tal tu?"
                    else -> "error"
                }
            }
            //Solo

            message.contains("me siento solo")->{
                when(random) {
                    0 -> "La mejor manera es platicar de tus sentimientos con la persona mas cercana que tengas"
                    1 -> "Recuerdalo, no estas solo. Busca a la persona de confianza que más cercana a ti"
                    2 -> "Si necesitas ayuda, es momento de pedirla"
                    else -> "error"
                }
            }

            //Dime algo

            message.contains("dime algo")||message.contains("cuentame algo")->{

                when(random) {
                    0 -> "Algo"
                    1 -> "Hoy es un día especial"
                    2 -> "Hoy es ${Time.timeStamp()}"
                    else -> "error"
                }
            }

            //Como sentime mejor

            message.contains("me quiero sentir mejor")||message.contains("como le hago para sentirme bien")->{
                when(random) {
                    0 -> "Siente mejor "
                    1 -> "Sonrie"
                    2 -> "Sal"
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