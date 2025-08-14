package com.optic.ecommerceappmvvm.domain.model.team

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


data class TeamResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") var name: String,
    @SerializedName("country") val country: String? = null,
    @SerializedName("founded") val founded: Int? = null,
    @SerializedName("code") val code: String? = null,
    @SerializedName("national") val national: Boolean? = null,
    @SerializedName("logo") val logo: String? = null,
    @SerializedName("venue") val venue: VenueResponse? = null,

): Serializable {

    fun toJson(): String = Gson().toJson(TeamResponse(
        id,
        name,
        country,
        founded,
        code,
        national,
        logo,
        venue
    ))

    companion object {
        fun fromJson(data: String): TeamResponse = Gson().fromJson(data, TeamResponse::class.java)
    }

}