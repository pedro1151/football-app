package com.optic.ecommerceappmvvm.presentation.screens.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.optic.ecommerceappmvvm.domain.model.fixture.FixtureResponse
import androidx.compose.ui.platform.LocalContext

@Composable
fun FixtureItem(fixture: FixtureResponse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            // Liga con logo
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(fixture.league?.logo)
                        .crossfade(true)
                        .build(),
                    contentDescription = fixture.league?.name,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = fixture.league?.name ?: "Unknown League",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Equipos y resultado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = fixture.teamHome?.logo,
                        contentDescription = fixture.teamHome?.name,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = fixture.teamHome?.name ?: "",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${fixture.goalsHome ?: "-"} : ${fixture.goalsAway ?: "-"}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = fixture.statusShort ?: "TBD",
                        style = MaterialTheme.typography.labelSmall
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AsyncImage(
                        model = fixture.teamAway?.logo,
                        contentDescription = fixture.teamAway?.name,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = fixture.teamAway?.name ?: "",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Fecha
            Text(
                text = fixture.date.substringBefore("T").replace("-", "/"),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}