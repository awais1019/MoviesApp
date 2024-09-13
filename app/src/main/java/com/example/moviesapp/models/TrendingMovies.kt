package com.example.moviesapp.models


import com.google.gson.annotations.SerializedName

data class TrendingMovies(
    @SerializedName("movies")
    val movies: List<Movie>
)