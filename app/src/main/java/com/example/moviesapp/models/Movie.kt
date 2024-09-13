package com.example.moviesapp.models


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("image")
    val image: String,
    @SerializedName("imdbRating")
    val imdbRating: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("timeline")
    val timeline: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: String
)