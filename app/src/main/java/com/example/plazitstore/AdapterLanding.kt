package com.example.plazitstore

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair


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

                itemView.setOnClickListener {
                    val  intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("title", titulo)
                    intent.putExtra("description", desc)
                    intent.putExtra("price", price)

                    val p1:Pair<View,String> = Pair.create(itemView.imgItemHeader,"transitionHeader")
                    val p2:Pair<View,String> = Pair.create(itemView.textTitleItem,"transitionTitle" )
                    val p3:Pair<View,String> = Pair.create(itemView.textDescItem, "transitionDesc")
                    val p4:Pair<View,String> = Pair.create(itemView.textPriceItem,"transitionPrice")

                    val options: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(itemView.context as Activity, p1, p2, p3, p4)
                    itemView.context.startActivity(intent,options.toBundle())
                }
            }

        }
    }
}