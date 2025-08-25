package com.optic.ecommerceappmvvm.presentation.screens.fixtures.detail.components.standings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.optic.ecommerceappmvvm.domain.model.fixture.Team
import com.optic.ecommerceappmvvm.domain.model.standing.StandingResponse

@Composable
fun LeagueStandingItem(
    standing: StandingResponse,
    teamHome: Team,
    teamAway: Team
) {
    val isHighlighted = standing.team?.id == teamHome.id || standing.team?.id == teamAway.id

    val ModernYellow = Color(0xFFFFC107) // Amarillo moderno
    val ModernRed = Color(0xFFE53935)    // Rojo moderno
    val ModernGreen = Color(0xFF43A047)  // Verde moderno
    val ModernBlue = Color(0xFF1E88E5)   // Azul moderno

    // Asignamos color según rank (ajusta reglas según tu liga)
    val indicatorColor = when (standing.rank) {
        in 1..4 -> ModernGreen
        5 -> ModernBlue
        6 -> ModernYellow
        in 17..20 -> ModernRed
        else ->         MaterialTheme.colorScheme.primary
    }

    val backgroundColor = if (isHighlighted) {
        MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.1f)
    } else {
        MaterialTheme.colorScheme.primaryContainer
    }

    val indicatorWidth = 6.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .padding(vertical = 4.dp) // padding solo arriba/abajo
    ) {
        // Barra lateral tipo FotMob
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(indicatorWidth)
                .align(Alignment.CenterStart)
                .background(indicatorColor)
        )

        // Contenido principal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = indicatorWidth + 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = standing.rank.toString(),
                modifier = Modifier.width(25.dp),
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = indicatorColor
            )

            AsyncImage(
                model = standing.team?.logo,
                contentDescription = standing.team?.name,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = standing.team?.name ?: "Unknown",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = standing.allPlayed?.toString() ?: "-",
                modifier = Modifier.width(30.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = standing.goalsDiff?.toString() ?: "-",
                modifier = Modifier.width(30.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = standing.points.toString(),
                modifier = Modifier.width(30.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}