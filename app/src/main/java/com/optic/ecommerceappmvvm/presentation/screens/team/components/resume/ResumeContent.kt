package com.optic.ecommerceappmvvm.presentation.screens.team.components.resume

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.components.fixture.nextFixture.NextFixture

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ResumeContent(
    paddingValues: PaddingValues,
    nextFixtureState: Resource<FixtureResponse>,
    topFiveFixtureState: Resource<List<FixtureResponse>>,
    teamId: Int,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            NextFixture(
                title = "Próximo partido",
                state = nextFixtureState,
                navController = navController
            )

        }
        item{
            TopTeamFixture(
                topFiveFixtureState = topFiveFixtureState,
                teamId = teamId
            )
        }

        // Aquí más adelante puedes agregar otros cards como el top 5
    }
}