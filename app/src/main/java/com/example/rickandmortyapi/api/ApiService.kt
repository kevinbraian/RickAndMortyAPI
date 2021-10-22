package com.example.rickandmortyapi.api

import com.example.rickandmortyapi.entities.ApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") query : Int): ApiResponse
}