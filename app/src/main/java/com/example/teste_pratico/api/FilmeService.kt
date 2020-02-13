package com.example.teste_pratico.api

import com.example.teste_pratico.model.Genre
import com.example.teste_pratico.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmeService {

    @GET("movie/upcoming")
    fun listFilmes(@Query ("api_key") api_key: String,
                   @Query ("language") language: String,
                   @Query ("page") page: String): Call<Movie>

    @GET("genre/movie/list")
    fun listGeneros(@Query ("api_key") api_key: String,
                   @Query ("language") language: String): Call<Genre>

}
