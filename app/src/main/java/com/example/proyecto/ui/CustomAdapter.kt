package com.example.proyecto.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.R
import com.example.proyecto.data.Modulo

class CustomAdapter(
    private val context: Context,
    private val itemClickListener: OnModuleClickListener
) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    private var dataList = mutableListOf<Modulo>()

    fun setListData(data: MutableList<Modulo>) {
        dataList = data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomAdapter.ViewHolder {
        val v =
            LayoutInflater.from(context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: CustomAdapter.ViewHolder, i: Int) {
        val module = dataList[i]
        viewHolder.bindView(module)
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0) {
            return dataList.size
        } else {
            return 0
        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(modulo: Modulo) {

            var itemTitle: TextView = itemView.findViewById(R.id.item_title)
            var itemImage: ImageView = itemView.findViewById(R.id.item_image)
            var itemDetail: TextView = itemView.findViewById(R.id.item_detail)
            itemView.setOnClickListener {
                itemClickListener.onItemClick(modulo.title)
            }
            Glide.with(context).load(modulo.imageUrl).into(itemImage)
            itemTitle.text = modulo.title
            itemDetail.text = modulo.des

        }
    }

    interface OnModuleClickListener {
        fun onItemClick(title: String)
        //fun onImageClick()
    }


}