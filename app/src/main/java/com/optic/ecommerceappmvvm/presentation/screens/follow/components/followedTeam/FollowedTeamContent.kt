package com.optic.ecommerceappmvvm.presentation.screens.follow.components.followedTeam


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.optic.ecommerceappmvvm.domain.model.player.Player
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.presentation.screens.client.Teams.list.components.TeamListContent
import com.optic.ecommerceappmvvm.presentation.screens.client.players.list.components.PlayerListContent


@Composable
fun FollowedTeamContent(
    teams: List<Team>,
    followedTeams: List<Team>,
    navController: NavHostController,
    onFollowClick: (Int) -> Unit = {},
    onUnFollowClick: (Int) -> Unit = {},
    paddingValues: PaddingValues
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {

        // Parte superior: jugadores seguidos
        FollowedTeamListContent(
            modifier = Modifier,
            followedTeams = followedTeams,
            onUnFollowClick = onUnFollowClick,
            navController = navController
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Parte inferior: lista completa de jugadores
        TeamListContent(
            modifier = Modifier.fillMaxSize(),
            teams = teams,
            navController = navController,
            paddingValues = PaddingValues(8.dp),
             onFollowClick = onFollowClick
        )
    }
}