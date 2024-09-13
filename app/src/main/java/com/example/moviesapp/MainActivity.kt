package com.example.moviesapp

import MoviesGrid
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.moviesapp.ui.theme.MoviesAppTheme
import com.example.moviesapp.viewmodels.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val moviesViewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                moviesViewModel.fetchTrendingMovies()
                MoviesScreen(moviesViewModel)
            }
        }
    }
}

@Composable
fun MoviesScreen(moviesViewModel: MoviesViewModel) {
    val trendingMovies by moviesViewModel.trendingMovies.collectAsState()
    MoviesGrid(movies = trendingMovies)
}
