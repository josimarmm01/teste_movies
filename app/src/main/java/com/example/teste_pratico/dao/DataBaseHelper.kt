//package com.example.teste_pratico.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.teste_pratico.model.Filme
import com.example.teste_pratico.model.FilmeDados
import com.example.teste_pratico.model.Genero
//import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
//import com.j256.ormlite.support.ConnectionSource
//import com.j256.ormlite.table.TableUtils

//class DataBaseHelper : OrmLiteSqliteOpenHelper {

//    companion object {
//        private val db = "fil.db"
//        private val versao = 1
//    }

//    constructor(context: Context) : super(context,db,null,versao)

//    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
//        TableUtils.createTable(connectionSource, FilmeDados::class.java)
//    }

//    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int, newVersion: Int) {
//    }

//    override fun close() {
//        super.close()
//    }

//}