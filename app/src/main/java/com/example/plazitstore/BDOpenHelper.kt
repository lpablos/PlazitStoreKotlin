package com.example.plazitstore

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*


class BDOpenHelper (ctx: Context): ManagedSQLiteOpenHelper(ctx,"PlatziStore",null,1) {

    companion object {
        private var instance: BDOpenHelper? = null
        @Synchronized
        fun getInstance(ctx: Context): BDOpenHelper? = if (instance == null) {
            BDOpenHelper(ctx)
        } else {
            instance
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val id = "id" to INTEGER + PRIMARY_KEY
        val name = "name" to TEXT
        val desc = "desc" to TEXT
        val price = "price" to REAL
        db?.createTable("productos",true, id,name,desc,price)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("productos",true)
    }

    val Context.database:BDOpenHelper? get() = getInstance(applicationContext)
}