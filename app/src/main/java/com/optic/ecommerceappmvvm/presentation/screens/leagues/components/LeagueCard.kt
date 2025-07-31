package com.optic.ecommerceappmvvm.presentation.screens.leagues.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.optic.ecommerceappmvvm.domain.model.League.League
import com.optic.ecommerceappmvvm.presentation.components.follow.FollowButton



// CARD PARA MOSTRAR LAS LIGAS
@Composable
fun LeagueCard(
    league: League,
    isFollowed: Boolean,
    onFollowClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
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

            // ✅ Acá es correcto usar un Composable
            FollowButton(
                isFollowed = isFollowed,
                onClick = onFollowClick
            )
        }
    }
}