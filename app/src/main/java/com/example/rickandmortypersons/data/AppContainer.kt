package com.example.rickandmortypersons.data

import android.app.Application
import com.example.rickandmortypersons.network.model.PersonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val personsRepository: PersonsRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://rickandmortyapi.com/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: PersonService by lazy {
        retrofit.create(PersonService::class.java)
    }
    override val personsRepository: PersonsRepository by lazy {
        NetworkPersonsRepository(retrofitService)
    }
}