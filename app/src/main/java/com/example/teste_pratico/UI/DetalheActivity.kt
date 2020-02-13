package com.example.teste_pratico.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.teste_pratico.R
//import com.example.teste_pratico.dao.DataBaseHelper
//import com.example.teste_pratico.dao.FilmeDAO
import com.example.teste_pratico.helper.FilmeConfig
import com.example.teste_pratico.model.Filme
import com.example.teste_pratico.model.FilmeDados
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe.*

class DetalheActivity : AppCompatActivity() {

    //var dbHelper: DataBaseHelper = DataBaseHelper(this)
    //var daoFilme: FilmeDAO = FilmeDAO(dbHelper.connectionSource)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val filmeDados = intent.getParcelableExtra<FilmeDados>("item_filme")

        exibir(filmeDados)

        btnSalvarFavorito.setOnClickListener {
            salvarFavoritos(filmeDados)
        }
    }

    private fun exibir(filmeDados: FilmeDados) {

        val titulo:TextView = findViewById(R.id.textTituloDetalhe)
        val data:TextView = findViewById(R.id.textDataDetalhe)
        val sinopse:TextView = findViewById(R.id.textSinopseDetalhe)
        val genero:TextView = findViewById(R.id.textGeneroDetalhe)
        val poster:ImageView = findViewById(R.id.imageDetalhe)

        if (filmeDados.overview.equals(""))
            filmeDados.overview = "Não Disponibilizado"

        if (filmeDados.overview.equals(""))
            filmeDados.title = "Não Disponibilizado"

        if (filmeDados.overview.equals(""))
            filmeDados.generos = "Não Disponibilizado"

        if (filmeDados.overview.equals(""))
            filmeDados.release_date = "Não Disponibilizado"

        genero.setText(filmeDados.generos)
        titulo.setText(filmeDados.title)
        data.setText(filmeDados.release_date)
        sinopse.setText(filmeDados.overview)
        Picasso.get().load(FilmeConfig.img_API() + FilmeConfig.img_500_API()
                + filmeDados.backdrop_path).into(poster)
    }

    private fun salvarFavoritos(filmeDados : FilmeDados) {

        //val value = daoFilme.create(filmeDados)
        //if (value == 1) {
        //    Toast.makeText(this, "Filme adicionado aos favoritos", Toast.LENGTH_LONG).show()
        //} else {
        //    Toast.makeText(this, "Falha ao adicionar", Toast.LENGTH_LONG).show()
        //}
    }

}

