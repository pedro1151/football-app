package com.optic.ecommerceappmvvm.presentation.screens.client.Teams.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.navigation.screen.client.ClientScreen
import com.optic.ecommerceappmvvm.presentation.components.ProgressBar
import com.optic.ecommerceappmvvm.presentation.screens.client.Teams.list.TeamListViewModel
import com.optic.ecommerceappmvvm.presentation.screens.client.Teams.list.components.TeamListContent

@Composable
fun TeamListScreen(
    navController: NavHostController

)
{
    val viewModel: TeamListViewModel = hiltViewModel()
    val playerResource by viewModel.teamsState.collectAsState()


    Scaffold(

    ) { paddingValues ->
        when (val result = playerResource) {
            is Resource.Loading -> {
                ProgressBar()
            }

            is Resource.Success -> {
                TeamListContent(modifier = Modifier, result.data, paddingValues)
            }

            is Resource.Failure -> {
                // mostrar error: result.message
            }
        }
    }
}