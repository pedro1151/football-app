package com.optic.ecommerceappmvvm.presentation.screens.leagues

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.presentation.screens.leagues.LeagueViewModel
import com.optic.ecommerceappmvvm.presentation.screens.leagues.components.LeagueSearchBar
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.delay

@Composable
fun LeagueContent(
    modifier: Modifier = Modifier,
    leagues: List<League>,
    paddingValues: PaddingValues,
    viewModel: LeagueViewModel
) {
    var query by remember { mutableStateOf("") }

    // Ejecutar solo una vez al montar el Composable para traer todas las ligas inicialmente
    LaunchedEffect(Unit) {
        viewModel.getLeagues()
    }

    // Observa los cambios en query, con debounce y sin cancelar corrutinas previas
    LaunchedEffect(Unit) {
        snapshotFlow { query }
            .debounce(400)
            .distinctUntilChanged()
            .collectLatest { value ->
                if (value.isBlank()) {
                    viewModel.getLeagues()
                } else {
                    viewModel.getLeagues(
                        name = value,
                        type = value,
                        countryName = value
                    )
                }
            }
    }

    Column(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)

    ) {
        LeagueSearchBar(
            query = query,
            onQueryChange = { query = it }
        )
        /*
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            placeholder = { Text("Buscar ligas") },
            singleLine = true
        )

         */

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(leagues) { league ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    /*
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),

                     */
                    elevation = CardDefaults.cardElevation(0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AsyncImage(
                            model = league.logo,
                            contentDescription = "Logo de ${league.name}",
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = league.name,
                            style = MaterialTheme.typography.bodyMedium.copy(fontSize = 13.sp),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}