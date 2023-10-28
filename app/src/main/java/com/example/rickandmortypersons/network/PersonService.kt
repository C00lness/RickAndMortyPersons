package com.example.rickandmortypersons.network.model

import com.example.rickandmortypersons.RickAndMortyPersons
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonService {
    @GET("character")
    suspend fun personSearch(): RickAndMortyPersons
}