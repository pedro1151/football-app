package com.optic.ecommerceappmvvm.data.dataSource.remote.service.external

import com.optic.ecommerceappmvvm.domain.model.AuthResponse
import com.optic.ecommerceappmvvm.domain.model.User
import retrofit2.Response

interface ExternalRemoteDataSource {

    suspend fun login(id_token: String): Response<AuthResponse>

}