package com.optic.ecommerceappmvvm.presentation.screens.follow


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.presentation.components.ProgressBar
import com.optic.ecommerceappmvvm.presentation.screens.follow.components.FollowContent
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.components.BackTopBar
import com.optic.ecommerceappmvvm.presentation.components.PrimaryTopBar
import com.optic.ecommerceappmvvm.presentation.ui.theme.GreyLight

@Composable
fun FollowScreen(
    navController: NavHostController
) {
    val viewModel: FollowViewModel = hiltViewModel()
    val teamsState by viewModel.teamsState.collectAsState()
    val playersState by viewModel.playersState.collectAsState()

    val followedPlayerListState by viewModel.followedPlayerListState.collectAsState()
    val filteredPlayers by viewModel.filteredPlayersState.collectAsState()

    // TEAMS SEGUIDOS
    val followedTeamListState by viewModel.followedTeamListState.collectAsState()
    // LISTA YA FILTRADA DE JUGADORES Q QUEDAN SIN SEGUIR
    val filteredTeams by viewModel.filteredTeamsState.collectAsState()


    Scaffold (
        topBar = {
            PrimaryTopBar(
                navController = navController,
                title = "Siguiendo"
            )
        } ,
        containerColor = GreyLight
    ){ paddingValues ->
        if (teamsState is Resource.Loading || playersState is Resource.Loading) {
            ProgressBar()
        } else if (teamsState is Resource.Success && playersState is Resource.Success) {
            FollowContent(
                paddingValues = paddingValues,
                teams = filteredTeams,
                players = filteredPlayers,
                followedPlayers = (followedPlayerListState as Resource.Success).data?: emptyList(),
                followedTeams = (followedTeamListState as Resource.Success).data?: emptyList(),
                navController = navController,
                onFollowClick = { playerId -> viewModel.createFollowedPlayer(playerId) } ,// 👈 PASÁS LA FUNCIÓN
                onUnFollowClick = { playerId -> viewModel.deleteFollowedPlayer(playerId) }, // 👈 PASÁS LA FUNCIÓN
                onFollowTeamClick = { teamId -> viewModel.createFollowedTeam(teamId) } ,// 👈 PASÁS LA FUNCIÓN
                onUnFollowTeamClick = { teamId -> viewModel.deleteFollowedTeam(teamId) } ,// 👈 PASÁS LA FUNCIÓN
            )
        }
        // Manejo de errores
        else if (teamsState is Resource.Failure || playersState is Resource.Failure) {
            // Puedes mostrar un mensaje de error
        }
    }
}