package com.optic.ecommerceappmvvm.presentation.screens.client.players.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.components.ProgressBar
import com.optic.ecommerceappmvvm.presentation.navigation.screen.client.ClientScreen
import com.optic.ecommerceappmvvm.presentation.screens.client.players.list.components.PlayerListContent

@Composable
fun PlayerListScreen(
    navController: NavHostController
) {
    val viewModel: PlayerListViewModel = hiltViewModel()
    val playerResource by viewModel.playersState.collectAsState()

    Scaffold(

    ) { paddingValues ->
        when (val result = playerResource) {
            is Resource.Loading -> {
                ProgressBar()
            }

            is Resource.Success -> {
                PlayerListContent(
                    modifier = Modifier,
                    players = result.data,
                    paddingValues = paddingValues,
                    navController = navController
                )
            }

            is Resource.Failure -> {
                // TODO: mostrar error
            }
        }
    }
}