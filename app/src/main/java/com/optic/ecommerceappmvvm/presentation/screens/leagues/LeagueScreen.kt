package com.optic.ecommerceappmvvm.presentation.screens.leagues

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.optic.ecommerceappmvvm.presentation.components.DefaultTopBar // Solo si usás topbar común
import com.optic.ecommerceappmvvm.presentation.components.PrimaryTopBar
import com.optic.ecommerceappmvvm.presentation.screens.leagues.components.LeagueSearchBar
import com.optic.ecommerceappmvvm.presentation.ui.theme.GreyLight

@Composable
fun LeagueScreen(navController: NavHostController) {
    val viewModel: LeagueViewModel = hiltViewModel()
    val leagueResource by viewModel.leaguesState.collectAsState()


    LaunchedEffect(Unit) {
        viewModel.getLeagues() // <- Llamada inicial sin filtros
    }

    Scaffold (
        topBar = {
            PrimaryTopBar(
                navController = navController,
                title = "Ligas Pedro"
            )
        } ,
        containerColor = GreyLight
    ){ paddingValues ->
        when (val result = leagueResource) {
            is Resource.Loading -> {
                ProgressBar()
            }
            is Resource.Success -> {
                LeagueContent(
                    modifier = Modifier,
                    leagues = result.data,
                    paddingValues = paddingValues,
                    viewModel = viewModel // 👈 importante pasarlo
                )
            }
            is Resource.Failure -> {
                // mostrar error con result.message
            }
        }
    }
}