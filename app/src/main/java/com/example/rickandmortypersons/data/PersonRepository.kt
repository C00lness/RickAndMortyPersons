package com.example.rickandmortypersons.data

import com.example.rickandmortypersons.network.model.PersonService

interface PersonsRepository {
    suspend fun getPersons(): List<Person>
}
class NetworkPersonsRepository(private val personService: PersonService) : PersonsRepository {
    override suspend fun getPersons(): List<Person> = personService.personSearch().results.map{
        results -> Person(
            name = results.name,
            description = results.name + " " + results.status + " " + results.species + results.gender,
            url = results.image
        )
    }
}
