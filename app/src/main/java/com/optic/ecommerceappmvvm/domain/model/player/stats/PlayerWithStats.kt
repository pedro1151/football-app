package com.optic.ecommerceappmvvm.domain.model.player.stats


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlayerWithStats(
    @SerializedName("id") val id: Int,
    @SerializedName("api_id") val apiId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("firstname") val firstname: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("age") val age: Int,
    @SerializedName("nationality") val nationality: String,
    @SerializedName("height") val height: String,
    @SerializedName("weight") val weight: String,
    @SerializedName("injured") val injured: Boolean,
    @SerializedName("photo") val photo: String,
    @SerializedName("statistics") val statistics: List<PlayerStats>
) : Serializable