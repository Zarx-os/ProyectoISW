package com.example.proyecto.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import com.example.proyecto.R
import com.example.proyecto.data.Message
import com.example.proyecto.utils.BotResponses
import com.example.proyecto.utils.Constants.OPEN_GOOGLE
import com.example.proyecto.utils.Constants.OPEN_SEARCH
import com.example.proyecto.utils.Constants.RECEIVE_ID
import com.example.proyecto.utils.Constants.SEND_ID
import com.example.proyecto.utils.Time
import kotlinx.coroutines.*

class ChatBot : AppCompatActivity() {
    private lateinit var adapter: MessagingAdapter
    private val bolList= listOf("Elizabeth","Karla","Mauricio","Alejandro")
    private lateinit var rv_messages: RecyclerView
    private lateinit var et_message:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)
        rv_messages=findViewById(R.id.rv_message)
        et_message=findViewById(R.id.et_message)
        recyclerView()
        clickEvents()
            val random=(0..3).random()
        customMessage("El dia de hoy estas hablando con ${bolList[random]} ¿en qué puedo ayudarte?")

    }
    private fun clickEvents(){
        val btn_send=findViewById<Button>(R.id.btn_send)
        btn_send.setOnClickListener{
            sendMessage()
        }
        et_message.setOnClickListener{
            GlobalScope.launch {
                delay(1000)
                withContext(Dispatchers.Main){
                    rv_messages.scrollToPosition(adapter.itemCount-1)
                }
            }
        }
    }
    private fun recyclerView(){
        adapter= MessagingAdapter()

        rv_messages.adapter=adapter
        rv_messages.layoutManager=
            LinearLayoutManager(applicationContext)


    }
    private fun sendMessage(){

        val message=et_message.text.toString()
        val timeStamp=Time.timeStamp()
        if(message.isNotEmpty()){
            et_message.setText("")
            adapter.insertMessage(Message(message,SEND_ID,timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount-1)
            botResponse(message)
        }
    }
    private fun botResponse(message:String){
        val timeStamp=Time.timeStamp()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val response=BotResponses.basicResponses(message)
                adapter.insertMessage(Message(response, RECEIVE_ID,timeStamp))
               rv_messages.scrollToPosition(adapter.itemCount-1)
                when(response){
                    OPEN_GOOGLE->{
                        val site=Intent(Intent.ACTION_VIEW)
                        site.data=Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH->{
                        val site=Intent(Intent.ACTION_VIEW)
                        val searchTerm:String?=message.substringAfter("search")
                        site.data= Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }
                }
            }
        }
    }
    override fun onStart(){
        super.onStart()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
   private fun customMessage(message:String){
        GlobalScope.launch{
            delay(1000)
            withContext(Dispatchers.Main){
                val timeStamp= Time.timeStamp()
                adapter.insertMessage(Message(message,RECEIVE_ID,timeStamp))
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
}