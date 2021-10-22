package com.example.rickandmortyapi.entities


import com.example.rickandmortyapi.entities.SingleCharacter
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("info")
    val info : Info,
    @SerializedName("results")
    val apiCharacters: List<SingleCharacter>
)
data class Info(val count : Int?, val pages: String?, val next: String?, val prev : String?)