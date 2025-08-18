package com.optic.ecommerceappmvvm.presentation.navigation.graph.client

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.optic.ecommerceappmvvm.presentation.navigation.Graph
import com.optic.ecommerceappmvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.optic.ecommerceappmvvm.presentation.navigation.screen.client.ClientScreen
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.PlayerStatsScreen
import com.optic.ecommerceappmvvm.presentation.screens.fixtures.detail.FixtureDetailScreen
import com.optic.ecommerceappmvvm.presentation.screens.follow.FollowScreen
import com.optic.ecommerceappmvvm.presentation.screens.leagues.LeagueScreen
import com.optic.ecommerceappmvvm.presentation.screens.mas.MasScreen
import com.optic.ecommerceappmvvm.presentation.screens.matches.MatchesScreen
import com.optic.ecommerceappmvvm.presentation.screens.team.TeamScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.Matches.route
    ) {

        composable(route = ClientScreen.Matches.route) {
            MatchesScreen(navController)
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

        composable(route = Graph.TEAM + "/{teamId}"
        ) { backStackEntry ->
            val teamId = backStackEntry.arguments?.getString("teamId")?.toInt() ?: 0
            TeamScreen(navController = navController, teamId = teamId)
        }
        // DETALLE DE FIXTURE
        composable(route = Graph.FIXTURE + "/{fixtureId}"
        ) { backStackEntry ->
            val fixtureId= backStackEntry.arguments?.getString("fixtureId")?.toInt() ?: 0
            FixtureDetailScreen(navController = navController, fixtureId = fixtureId)
        }




        ProfileNavGraph(navController)

    }
}