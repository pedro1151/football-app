package com.optic.ecommerceappmvvm.presentation.screens.profile.update.mapper

import com.optic.ecommerceappmvvm.domain.model.User
import com.optic.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        username = name
    )
}