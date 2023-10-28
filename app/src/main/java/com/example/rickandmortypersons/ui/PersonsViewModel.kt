package com.example.rickandmortypersons.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rickandmortypersons.data.Person
import com.example.rickandmortypersons.data.PersonsRepository
import com.example.rickandmortypersons.ui.PersonsApplication
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.http.HTTP
import java.io.IOException

sealed interface PersonsUIState {
    data class Success(val personsSearch: List<Person>) : PersonsUIState
    object Error : PersonsUIState
    object Loading : PersonsUIState
}


class PersonsViewModel (private val personsRepository: PersonsRepository) : ViewModel() {
    var personsUIState: PersonsUIState by mutableStateOf(PersonsUIState.Loading)
        private set
    init {
        getPersons()
    }
    fun getPersons(){
        viewModelScope.launch {
            personsUIState = PersonsUIState.Loading
            personsUIState = try {
                PersonsUIState.Success(personsRepository.getPersons())
            } catch (e: IOException) {
                PersonsUIState.Error
            } catch (e: HttpException) {
                PersonsUIState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PersonsApplication)
                val personsRepository = application.container.personsRepository
                PersonsViewModel(personsRepository = personsRepository)
            }
        }
    }
}