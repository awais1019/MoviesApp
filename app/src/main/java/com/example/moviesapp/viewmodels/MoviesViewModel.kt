package com.example.moviesapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.Repository

import com.example.moviesapp.models.TrendingMovies
import com.example.moviesapp.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    private val _trendingMovies = MutableStateFlow<List<Movie>>(emptyList())
    val trendingMovies: StateFlow<List<Movie>> = _trendingMovies

    fun fetchTrendingMovies() {
        viewModelScope.launch {
            try {
                val response: Response<TrendingMovies> = repository.getTrendingMovies()
                if (response.isSuccessful) {
                    val trendingMoviesResponse = response.body()
                    _trendingMovies.value = trendingMoviesResponse?.movies ?: emptyList()
                } else {
                    Log.e("MoviesViewModel", "Error: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("MoviesViewModel", "Exception: ${e.message}", e)
            }
        }
    }
}
