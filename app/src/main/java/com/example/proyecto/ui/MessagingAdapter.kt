package com.example.proyecto.ui

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.proyecto.R
import com.example.proyecto.data.Message
import com.example.proyecto.utils.Constants.RECEIVE_ID
import com.example.proyecto.utils.Constants.SEND_ID

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messageList= mutableListOf<Message>()
   inner class MessageViewHolder(itemView: View):
       RecyclerView.ViewHolder(itemView){
       init{
           itemView.setOnClickListener{
               messageList.removeAt(adapterPosition)
               notifyItemRemoved(adapterPosition)
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_item,parent,false))
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage= messageList[position]
        when(currentMessage.id){
            SEND_ID->{
                holder.itemView.findViewById<TextView>(R.id.tv_message).apply {
                    text=currentMessage.message
                    visibility=View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tv_bot_message).visibility=View.GONE
            }
            RECEIVE_ID->{
                holder.itemView.findViewById<TextView>(R.id.tv_bot_message).apply{
                    text=currentMessage.message
                    visibility=View.VISIBLE
                }
                holder.itemView.findViewById<TextView>(R.id.tv_message).visibility=View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
    fun insertMessage(message: Message){
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
    }
}