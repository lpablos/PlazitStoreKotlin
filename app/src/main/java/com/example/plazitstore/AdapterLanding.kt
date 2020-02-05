package com.example.plazitstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_landing.view.*

class AdapterLanding ( val datos: List<ItemLanding> ) : RecyclerView.Adapter<AdapterLanding.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_landing, parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(datos[position])
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ItemLanding){
            with(item){
                itemView.textTitleItem.text = titulo
                itemView.textDescItem.text = desc
                itemView.textPriceItem.text = "$ ${String.format("%.2f",price)}"
            }

        }
    }
}