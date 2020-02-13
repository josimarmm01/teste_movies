package com.example.teste_pratico.model

data class Movie(
    val results: List<Filme>,
    val page: String,
    val total_results: String,
    val total_pages: String
)