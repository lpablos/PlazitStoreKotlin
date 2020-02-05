package com.example.plazitstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recicleViewList.layoutManager = GridLayoutManager(this, 2)
        //Esta es la creacion de la lista
        val itemShop = (0..20).map {
            ItemLanding("Titulo $it", "descripcion $it", 5.23+it)
        }
        //Este es el adaptador

        val adaptador = AdapterLanding(itemShop)
        recicleViewList.adapter = adaptador
    }
}
