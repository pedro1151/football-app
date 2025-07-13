package com.optic.ecommerceappmvvm.domain.model

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("username") var username: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("password") val password: String? = null,
    @SerializedName("roles") val roles: List<Rol>? = null,
): Serializable {

    fun toJson(): String = Gson().toJson(User(
        id,
        username,
        email,
        password,
        /*
        if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",

        notificationToken,
        */
        roles?.map { rol -> Rol.fromJson(rol.toJson())}
    ))

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }

}
