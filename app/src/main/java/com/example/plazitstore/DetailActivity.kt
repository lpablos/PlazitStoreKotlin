package com.example.plazitstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_descr.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        /*intent?.let {
            val textFromMain: String? = it.extras?.getString("text")
            textDetail.text = textFromMain.toString()
        }*/
        intent?.extras?.let {
            txtDetailTitulo.text = it.getString("title")
            txtDetailDesc.text = it.getString("description")
            txtDetailPrice.text = "$ ${String.format("%.2f",it.getDouble("price"))}"
        }
    }
}
