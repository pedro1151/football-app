package com.optic.ecommerceappmvvm.presentation.screens.matches

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
fun FixtureScreen(navController: NavHostController) {
    val viewModel: FixtureViewModel = hiltViewModel()

    val fixtureState by viewModel.fixtureTeamsState.collectAsState()

    // Llamamos la función cuando entra la pantalla
    LaunchedEffect(Unit) {
        viewModel.getFixtureFollowedTeams(season = 2023, date = "2023-09-17")
    }

    FixtureContent(
        navController = navController,
        fixtureState = fixtureState
    )
}