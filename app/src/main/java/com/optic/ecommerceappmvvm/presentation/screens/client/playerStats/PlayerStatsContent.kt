package com.optic.ecommerceappmvvm.presentation.screens.client.playerStats

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.optic.ecommerceappmvvm.domain.model.player.stats.PlayerWithStats

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.navigation.NavController
import com.optic.ecommerceappmvvm.domain.model.player.playerteams.PlayerTeamsResponse
import com.optic.ecommerceappmvvm.domain.util.Resource

import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.components.PlaceholderTab
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.components.PlayerHeader
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.components.PlayerProfileTab
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.components.PlayerStatsContentTab
import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.trayectoria.PlayerTeamsContent
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun PlayerStatsContent(
    paddingValues: PaddingValues,
    playerStats: PlayerWithStats,
    navController: NavController,
    playerTeamsState: Resource<PlayerTeamsResponse>
) {
    val tabTitles = listOf("Perfil", "Estadísticas", "Partidos", "Trayectoria")
    val pagerState = rememberPagerState(pageCount = { tabTitles.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)

    ) {
        PlayerHeader(playerStats, paddingValues)

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch{
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> PlayerProfileTab(playerStats)
                1 -> PlayerStatsContentTab(paddingValues = PaddingValues(8.dp), playerStats = playerStats)
                2 -> PlaceholderTab("Partidos")
                3 -> PlayerTeamsContent(
                    paddingValues = paddingValues,
                    state = playerTeamsState
                )
            }
        }
    }
}




