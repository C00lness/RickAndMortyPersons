package com.example.rickandmortypersons.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmortypersons.R
import com.example.rickandmortypersons.ui.screens.HomeScreen
import com.example.rickandmortypersons.ui.theme.PersonsViewModel


@Composable
fun PersonsApp(
    modifier: Modifier = Modifier
) {
    val personsViewModel: PersonsViewModel =
        viewModel(factory = PersonsViewModel.Factory)

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar (
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }

    ) {
        Surface(modifier = modifier
            .fillMaxSize()
            .padding(it),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(
                personsUiState = personsViewModel.personsUIState,
                retryAction = { personsViewModel.getPersons() },
                modifier = modifier
            )
        }
    }
}