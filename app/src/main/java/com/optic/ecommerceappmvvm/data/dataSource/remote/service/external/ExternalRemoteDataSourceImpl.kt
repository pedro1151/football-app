package com.optic.ecommerceappmvvm.data.dataSource.remote.service.external

import com.optic.ecommerceappmvvm.data.dataSource.remote.service.ExternalService
import com.optic.ecommerceappmvvm.domain.model.AuthResponse
import com.optic.ecommerceappmvvm.domain.model.LoginRequest
import com.optic.ecommerceappmvvm.domain.model.external.GoogleAuthRequest
import retrofit2.Response

class ExternalRemoteDataSourceImpl(private val externalService: ExternalService): ExternalRemoteDataSource {


    override suspend fun login(id_token: String) = externalService.login(GoogleAuthRequest( id_token))


}