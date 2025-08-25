package com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.trayectoria


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.PlayerStatsViewModel

@Composable
fun PlayerTeamsScreen(
    playerId: Int,
    paddingValues: PaddingValues,
    viewModel: PlayerStatsViewModel = hiltViewModel()
) {
    val playerTeamsState by viewModel.playerTeamsState.collectAsState()

    // Llamar al ViewModel solo una vez al entrar en pantalla
    LaunchedEffect(playerId) {
        viewModel.getPlayerTeams(playerId)
    }

    PlayerTeamsContent(
        paddingValues = paddingValues,
        state = playerTeamsState
    )
}