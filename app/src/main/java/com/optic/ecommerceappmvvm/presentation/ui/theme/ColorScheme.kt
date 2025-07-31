package com.optic.ecommerceappmvvm.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ColorScheme
import com.optic.ecommerceappmvvm.presentation.ui.theme.AppThemeMode
import com.optic.ecommerceappmvvm.presentation.ui.theme.LocalAppTheme

val FollowButtonBackgroundLight = Color(0xFFF2F2F2)
val FollowButtonTextLight = Color(0xFF4A4A4A)

val FollowButtonBackgroundDark = Color(0xFF8E24AA)
val FollowButtonTextDark = Color.White


val SelectedTextColorLight = Grafito
val SelectedIconColorLight = Grafito

val SelectedTextColorDark = Color(0XFF2dad0D)
val SelectedIconColorDark = Color(0XFF2dad0D)

val IconColorDark = Color(0xFFFF4D4D)
val IconColorLight = Color(0xFFFF4D4D)

val ColorScheme.followButtonBackground: Color
    @Composable get() = when (LocalAppTheme.current.value) {
        AppThemeMode.DARK -> FollowButtonBackgroundDark
        AppThemeMode.LIGHT -> FollowButtonBackgroundLight
    }

val ColorScheme.followTextColor: Color
    @Composable get() = when (LocalAppTheme.current.value) {
        AppThemeMode.DARK -> FollowButtonTextDark
        AppThemeMode.LIGHT -> FollowButtonTextLight
    }


val ColorScheme.selectedTextColor: Color
    @Composable get() = when (LocalAppTheme.current.value) {
        AppThemeMode.DARK -> SelectedTextColorDark
        AppThemeMode.LIGHT -> SelectedTextColorLight
    }

val ColorScheme.selectedIconColor: Color
    @Composable get() = when (LocalAppTheme.current.value) {
        AppThemeMode.DARK -> SelectedIconColorDark
        AppThemeMode.LIGHT -> SelectedIconColorLight
    }

val ColorScheme.IconSecondaryColor: Color
    @Composable get() = when (LocalAppTheme.current.value) {
        AppThemeMode.DARK -> IconColorDark
        AppThemeMode.LIGHT -> IconColorLight
    }