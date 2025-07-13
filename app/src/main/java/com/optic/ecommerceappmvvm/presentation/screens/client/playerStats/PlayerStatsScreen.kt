package com.optic.ecommerceappmvvm.presentation.screens.client.playerStats

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.components.BackTopBar

import com.optic.ecommerceappmvvm.presentation.components.ProgressBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayerStatsScreen(
    playerId: Int,
    navController: NavHostController

    )
{
    val viewModel: PlayerStatsViewModel = hiltViewModel()

    val state by viewModel.playerStatsState.collectAsState()

    // Llamar a la función solo una vez al inicio
    LaunchedEffect(playerId) {
        viewModel.getPlayerStats(playerId)
    }


    Scaffold(
        topBar = {
            BackTopBar(
                navController = navController
            )
        }
    ) { paddingValues ->
        when (state) {
            is Resource.Loading -> {
                ProgressBar()
            }

            is Resource.Success -> {
                val data = (state as Resource.Success).data
                PlayerStatsContent(paddingValues, data, navController)
            }

            is Resource.Failure -> {
                // mostrar error: result.message
            }
        }

    }
}