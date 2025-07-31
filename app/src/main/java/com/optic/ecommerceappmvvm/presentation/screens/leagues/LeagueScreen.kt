package com.optic.ecommerceappmvvm.presentation.screens.leagues

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.components.ProgressBar
import androidx.compose.runtime.*
import com.optic.ecommerceappmvvm.presentation.components.PrimaryTopBar
import com.optic.ecommerceappmvvm.presentation.ui.theme.GreyLight

@Composable
fun LeagueScreen(navController: NavHostController) {
    val viewModel: LeagueViewModel = hiltViewModel()
    val leagueResource by viewModel.leaguesState.collectAsState()
    val followedLeaguesResource by viewModel.followedLeaguesListState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getLeagues()
        viewModel.getFollowedLeagues()
    }

    Scaffold(
        topBar = {
            PrimaryTopBar(
                navController = navController,
                title = "Ligas Pedro"
            )
        },
        containerColor = GreyLight
    ) { paddingValues ->

        val followed = (followedLeaguesResource as? Resource.Success)?.data ?: emptyList()

        when (val result = leagueResource) {
            is Resource.Loading -> {
                ProgressBar()
            }
            is Resource.Success -> {
                LeagueContent(
                    modifier = Modifier,
                    leagues = result.data,
                    followedLeagues = followed,
                    paddingValues = paddingValues,
                    viewModel = viewModel
                )
            }
            is Resource.Failure -> {
                // mostrar error si querés
            }
        }
    }
}