package com.optic.ecommerceappmvvm.presentation.screens.fixtures.detail.components.facetoface

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.screens.fixtures.detail.FixtureDetailViewModel
import com.optic.ecommerceappmvvm.presentation.screens.fixtures.list.FixtureList

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun VersusFixtureContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    fixture: FixtureResponse,
    paddingValues: PaddingValues
) {

    val viewModel: FixtureDetailViewModel = hiltViewModel()
    val versusFixtureState by viewModel.versusFixtureState.collectAsState()

    LaunchedEffect(
        fixture.teamHome.id,
        fixture.teamAway.id,
        fixture.league.id,
        fixture.leagueSeason
    ) {
        viewModel.getVersusFixture(
            fixture.teamHome.id,
            fixture.teamAway.id,
            fixture.league.id,
            fixture.leagueSeason
        )
    }

    FixtureList(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        fixtureState = versusFixtureState,
        title = "Cara a Cara"
    )
}