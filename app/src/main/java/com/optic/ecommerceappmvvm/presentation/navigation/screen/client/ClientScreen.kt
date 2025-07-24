package com.optic.ecommerceappmvvm.presentation.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Leagues: ClientScreen(
        route = "client/leagues",
        title = "Ligas",
        icon = Icons.Default.AccountCircle
    )
    object Matches: ClientScreen(
        route = "client/matches",
        title = "Matches",
        icon = Icons.Default.Share
    )

    object Profile: ClientScreen(
        route = "client/profile",
        title = "Menu",
        icon = Icons.Default.Menu
    )

    object Estadisticas: ClientScreen(
        route = "client/players/estadisticas",
        title = "Estadisticas",
        icon = Icons.Default.Send
    )

    object Fixture: ClientScreen(
        route = "client/players/fixture",
        title = "Perfil",
        icon = Icons.Default.Info
    )

    object Historial: ClientScreen(
        route = "client/players/historial",
        title = "Historial",
        icon = Icons.Default.DateRange
    )

    object Follow: ClientScreen(
        route = "client/follow",
        title = "Siguiendo",
        icon = Icons.Default.Star
    )

    object Mas: ClientScreen(
        route = "client/mas",
        title = "Menu",
        icon = Icons.Default.Menu
    )


}

