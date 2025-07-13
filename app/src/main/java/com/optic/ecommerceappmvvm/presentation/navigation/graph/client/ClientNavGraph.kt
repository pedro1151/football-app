package com.optic.ecommerceappmvvm.presentation.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.optic.ecommerceappmvvm.presentation.navigation.Graph
import com.optic.ecommerceappmvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.optic.ecommerceappmvvm.presentation.navigation.screen.client.ClientScreen
import com.optic.ecommerceappmvvm.presentation.screens.client.Teams.list.TeamListScreen
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.PlayerStatsScreen
import com.optic.ecommerceappmvvm.presentation.screens.client.players.list.PlayerListScreen
import com.optic.ecommerceappmvvm.presentation.screens.follow.FollowScreen
import com.optic.ecommerceappmvvm.presentation.screens.leagues.LeagueScreen
import com.optic.ecommerceappmvvm.presentation.screens.leagues.LeagueViewModel
import com.optic.ecommerceappmvvm.presentation.screens.mas.MasScreen
import com.optic.ecommerceappmvvm.presentation.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.TeamList.route
    ) {

        composable(route = ClientScreen.TeamList.route) {
            TeamListScreen(navController)
        }

        composable(route = ClientScreen.Follow.route) {
            FollowScreen(navController)
        }

        composable(route = ClientScreen.Leagues.route) {
            LeagueScreen(navController)
        }

        composable(route = ClientScreen.Profile.route) {
            MasScreen(navController)
        }

        composable(route = ClientScreen.Mas.route) {
            MasScreen(navController)
        }

        composable(route = Graph.PLAYER + "/{playerId}"
        ) { backStackEntry ->
            val playerId = backStackEntry.arguments?.getString("playerId")?.toInt() ?: 0
            PlayerStatsScreen(navController = navController, playerId = playerId)
        }


        ProfileNavGraph(navController)

    }
}