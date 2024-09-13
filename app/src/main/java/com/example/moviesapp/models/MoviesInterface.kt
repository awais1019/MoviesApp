package com.example.moviesapp.models

import com.example.moviesapp.utils.ApiConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface MoviesInterface {

     @GET(ApiConstants.TRENDING_MOVIES_ENDPOINT)
     @Headers(
          "x-apihub-key: ${ApiConstants.API_KEY}",
          "x-apihub-host: ${ApiConstants.API_HOST}",
          "x-apihub-endpoint: ${ApiConstants.API_ENDPOINT_FOR_TRADING_MOVIES}"
     )
     suspend fun getTrendingMovies(): Response<TrendingMovies>

}