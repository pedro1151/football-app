package com.optic.ecommerceappmvvm.presentation.ui.theme


import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
enum class AppThemeMode { LIGHT, DARK }

val LocalAppTheme = compositionLocalOf { mutableStateOf(AppThemeMode.LIGHT) }