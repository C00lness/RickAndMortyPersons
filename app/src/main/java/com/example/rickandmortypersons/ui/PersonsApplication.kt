package com.example.rickandmortypersons.ui

import android.app.Application
import com.example.rickandmortypersons.data.AppContainer
import com.example.rickandmortypersons.data.DefaultAppContainer

class PersonsApplication : Application() {
        lateinit var container: AppContainer
        override fun onCreate() {
            super.onCreate()
            container = DefaultAppContainer()
        }
}