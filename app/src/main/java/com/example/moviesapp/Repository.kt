package com.example.moviesapp

import com.example.moviesapp.models.MoviesInterface
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: MoviesInterface) {


    suspend fun getTrendingMovies()= apiService.getTrendingMovies()

}