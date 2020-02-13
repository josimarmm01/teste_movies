package com.example.teste_pratico.UI

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.teste_pratico.R
import com.example.teste_pratico.adapter.RecyclerItemClickListener
import com.example.teste_pratico.api.RetrofitInitializer
import com.example.teste_pratico.helper.FilmeConfig
import com.example.teste_pratico.model.*
import kotlinx.android.synthetic.main.fragment_catalago.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import kotlin.math.log
import com.example.teste_pratico.adapter.FilmeAdapter as FilmeAdapter

/**
 * A simple [Fragment] subclass.
 */
class CatalagoFragment : Fragment() {

    private var lista_generos: List<Genero> = ArrayList()
    private var lista_filmes: ArrayList<FilmeDados> = ArrayList()

    private lateinit var listItems:View
    private lateinit var rv_frag_listar: RecyclerView
    private lateinit var layoutManager:RecyclerView.LayoutManager

    private var filmeAdpter: FilmeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listItems  = inflater.inflate(R.layout.fragment_catalago, container, false)
        rv_frag_listar = listItems.findViewById<View>(R.id.recycler_view_Filmes) as RecyclerView
        layoutManager = LinearLayoutManager(requireContext())

        retrfitGenero()

        rv_frag_listar!!.addOnItemTouchListener(
            RecyclerItemClickListener(
                requireContext(),
                rv_frag_listar!!,
                object : RecyclerItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {

                        var filme = lista_filmes[position]

                        val intent = Intent(requireContext(), DetalheActivity::class.java)
                        intent.putExtra("item_filme", filme)
                        startActivity(intent)

                    }

                    override fun onLongItemClick(view: View, position: Int) {
                    }

                })
        )
        return listItems
    }

    private fun retrfitGenero() {

        RetrofitInitializer().noteService().listGeneros(
            FilmeConfig.chave_API(),
            FilmeConfig.lingue_API()
        ).enqueue(object : Callback<Genre> {

            override fun onResponse(call: Call<Genre>?, response: Response<Genre>?) {
                var generos: Genre? = response?.body()
                generos?.genres?.let {
                    lista_generos = it
                }
                retrofitMovie()
            }

            override fun onFailure(call: Call<Genre>?, t: Throwable?) {
                if (t != null) {
                    Toast.makeText(requireContext(), "Não há Conexão com a Internet", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun retrofitMovie() {

        RetrofitInitializer().noteService().listFilmes(
            FilmeConfig.chave_API(),
            FilmeConfig.lingue_API(),
            FilmeConfig.page_API()
        ).enqueue(object : Callback<Movie> {

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {

                var filmes: Movie? = response?.body()
                filmes?.results?.let {
//
                    for (filme:Filme in it) {
                        lista_filmes.add(converteFilme(filme))
                    }
                    configurarList()
                }
            }

            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                Toast.makeText(requireContext(), "Não há Conexão com a Internet", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun configurarList() {

        filmeAdpter = FilmeAdapter()
        rv_frag_listar.setHasFixedSize(false)
        rv_frag_listar.layoutManager = layoutManager
        rv_frag_listar.adapter = filmeAdpter
        filmeAdpter?.addItens(lista_filmes)
    }

    private fun listarGenero(ids: List<String>): String {

        var aux:String = "| "
        for (id_genero in ids) {
            for (genero in lista_generos) {
                if (genero.id == id_genero) {
                    aux += genero.name + " | "
                }
            }
        }
        return aux
    }

    private fun converteFilme(filme: Filme): FilmeDados {
        val filmeDados = FilmeDados()

        filmeDados.id = filme.id
        filmeDados.generos = listarGenero(filme.genre_ids)
        filmeDados.title = filme.title
        //filmeDados.backdrop_path = filme.backdrop_path
        filmeDados.overview = filme.overview
        filmeDados.poster_path = filme.poster_path
        filmeDados.release_date = filme.release_date

        return filmeDados
    }

}

