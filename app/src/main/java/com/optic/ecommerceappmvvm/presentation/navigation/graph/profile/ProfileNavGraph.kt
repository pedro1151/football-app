package com.optic.ecommerceappmvvm.presentation.navigation.graph.profile

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.optic.ecommerceappmvvm.presentation.navigation.Graph
import com.optic.ecommerceappmvvm.presentation.navigation.screen.profile.ProfileScreen
import com.optic.ecommerceappmvvm.presentation.navigation.screen.roles.RolesScreen
import com.optic.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.optic.ecommerceappmvvm.presentation.screens.home.ClientHomeScreen
//import com.optic.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateScreen
import com.optic.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route
    ) {

        composable(
            route = ProfileScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                //ProfileUpdateScreen(navController, userParam = it)
            }
        }

    }
}