package com.example.rickandmortypersons

import com.google.gson.annotations.SerializedName


data class RickAndMortyPersons (

  @SerializedName("info"    ) var info    : Info?              = Info(),
  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)