package com.optic.ecommerceappmvvm.presentation.screens.matches

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.presentation.screens.matches.components.FixtureItem

@Composable
fun FixtureContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    fixtureState: Resource<List<FixtureResponse>>
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Matches",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

        when (fixtureState) {
            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(fixtureState.data ?: emptyList()) { fixture ->
                        FixtureItem(fixture = fixture)
                    }
                }
            }

            is Resource.Failure -> {
                Text(
                    text = "Error",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}