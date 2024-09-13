package com.example.moviesapp.di.module

import android.content.Context
import com.example.moviesapp.models.MoviesInterface
import com.example.moviesapp.utils.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun getRetrofitInstance(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun getInterface(retrofit: Retrofit): MoviesInterface{
        return retrofit.create(MoviesInterface::class.java)
    }

}