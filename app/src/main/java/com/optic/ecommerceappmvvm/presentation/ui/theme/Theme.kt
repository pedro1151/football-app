package com.optic.ecommerceappmvvm.presentation.ui.theme


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

// Define aquí tus colores personalizados como Color de Compose
val Blue500 = Color(0xFF1565C0) // ejemplo
val Blue700 = Color(0xFF1976D2)
val Purple200 = Color(0xFFBB86FC)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Teal500 = Color(0xFF018786)
val WhiteMe = Color (0xFFFFFFFF)
val Grafito = Color(0xFF4A4A4A)
val azulMarino = Color(0xFF1565C0)



private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = Color.White,
    primaryContainer = azulMarino,
    onPrimaryContainer = Color.White,
    secondary = Teal500,
    onSecondary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = WhiteMe,
    onSurface = Color.Black,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    onPrimary = Color.Black,
    primaryContainer = Grafito,
    onPrimaryContainer = WhiteMe,
    secondary = Teal200,
    onSecondary = Color.Black,
    background = Grafito,
    onBackground = WhiteMe,
    surface = WhiteMe,
    onSurface = Color.White,
)


@Composable
fun EcommerceAppMVVMTheme(
    themeMode: AppThemeMode = AppThemeMode.LIGHT,
    content: @Composable () -> Unit
) {
    val colorScheme = when (themeMode) {
        AppThemeMode.LIGHT -> LightColorScheme
        AppThemeMode.DARK -> DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}