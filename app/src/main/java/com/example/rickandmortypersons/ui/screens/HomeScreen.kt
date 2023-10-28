package com.example.rickandmortypersons.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmortypersons.ui.theme.PersonsUIState

@Composable
fun HomeScreen(
    personsUiState: PersonsUIState,
    retryAction: () -> Unit,
    modifier: Modifier
) {
    when (personsUiState) {
        is PersonsUIState.Loading -> LoadingScreen(modifier)
        is PersonsUIState.Success -> PersonsGridScreen(
            pers = personsUiState.personsSearch,
            modifier = modifier
        )
        is PersonsUIState.Error -> ErrorScreen(retryAction = retryAction, modifier)
        else -> {}
    }
}