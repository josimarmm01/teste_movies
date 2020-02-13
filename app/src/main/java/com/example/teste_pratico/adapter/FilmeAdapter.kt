package com.example.teste_pratico.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.teste_pratico.R
import com.example.teste_pratico.helper.FilmeConfig
import com.example.teste_pratico.model.FilmeDados
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.filme_item.view.*

class FilmeAdapter : RecyclerView.Adapter<FilmeAdapter.MyViewHolder>{

    private var list_filmes: List<FilmeDados> = ArrayList()

    constructor() {
        this.list_filmes = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filme_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list_filmes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val filme: FilmeDados = list_filmes[position]

        holder.titulo.text = filme.title
        holder.data.text = filme.release_date
        holder.genero.text =  filme.generos
        Picasso.get().load(FilmeConfig.img_API() +
                FilmeConfig.img_w185_API() + filme.poster_path).into(holder.imagem)

    }

    fun addItens(list_filmes: List<FilmeDados>) {
        this.list_filmes = list_filmes
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo: TextView = itemView.textTitulo
        val data: TextView = itemView.textData
        val genero: TextView = itemView.textGenero
        var imagem: ImageView = itemView.imagemFilme

    }

}