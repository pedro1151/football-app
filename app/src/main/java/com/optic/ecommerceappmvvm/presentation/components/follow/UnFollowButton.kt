package com.optic.ecommerceappmvvm.presentation.components.follow

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.optic.ecommerceappmvvm.presentation.ui.theme.Grafito
import com.optic.ecommerceappmvvm.presentation.ui.theme.GreyLight

@Composable
fun UnFollowButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier ,// 👈 esto permite usar .align() desde afuera
    visible: Boolean = true // Útil si querés animar visibilidad luego
) {
    AnimatedVisibility(visible = visible) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(28.dp)
                .shadow(6.dp, CircleShape) // 👈 Elevación suave
                .background(
                    color = GreyLight,
                    shape = CircleShape
                )
                .clip(CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Dejar de seguir",
                tint = Grafito,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}