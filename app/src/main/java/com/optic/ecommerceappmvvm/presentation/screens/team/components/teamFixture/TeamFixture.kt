package com.optic.ecommerceappmvvm.presentation.screens.team.components.teamFixture

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.screens.matches.FixtureContent

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TeamFixture(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    fixtureState: Resource<List<FixtureResponse>>,
    title: String = "Siguiendo",
    paddingValues: PaddingValues
) {

    FixtureContent(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        fixtureState = fixtureState,
        title = "Partidos"
    )
}