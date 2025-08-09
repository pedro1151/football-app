package com.optic.ecommerceappmvvm.presentation.screens.team


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
import com.optic.ecommerceappmvvm.domain.model.Team

import com.optic.ecommerceappmvvm.presentation.screens.client.playerStats.components.PlaceholderTab
import com.optic.ecommerceappmvvm.presentation.screens.team.components.TeamHeader
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun TeamContent(
    paddingValues: PaddingValues,
    team: Team,
    navController: NavController
) {
    val tabTitles = listOf("Resumen", "Formacion", "Partidos", "Estadisticas", "Trofeos", "Novedades")
    val pagerState = rememberPagerState(pageCount = { tabTitles.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)

    ) {
        TeamHeader(team, paddingValues)

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
                0 -> PlaceholderTab("Resumen")
                1 -> PlaceholderTab("Formacion")
                2 -> PlaceholderTab("Partidos")
                3 -> PlaceholderTab("Estadisticas")
                4 -> PlaceholderTab("Trofeos")
                5 -> PlaceholderTab("Novedades")
            }
        }
    }
}
