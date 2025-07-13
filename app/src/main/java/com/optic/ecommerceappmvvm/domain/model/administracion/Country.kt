package com.optic.ecommerceappmvvm.domain.model.administracion

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(
    @SerializedName("id") val id: Int,
    @SerializedName("api_id") val apiId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("code") val code: String,
    @SerializedName("flag") val logo: String
) : Serializable