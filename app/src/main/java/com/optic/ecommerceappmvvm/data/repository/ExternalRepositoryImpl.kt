package com.optic.ecommerceappmvvm.data.repository

import com.optic.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSource
import com.optic.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.optic.ecommerceappmvvm.data.dataSource.remote.service.external.ExternalRemoteDataSource
import com.optic.ecommerceappmvvm.domain.model.AuthResponse
import com.optic.ecommerceappmvvm.domain.model.User
import com.optic.ecommerceappmvvm.domain.repository.AuthRepository
import com.optic.ecommerceappmvvm.domain.repository.ExternalRepository
import com.optic.ecommerceappmvvm.domain.util.Resource
import com.optic.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class ExternalRepositoryImpl(
    private val externalRemoteDataSource: ExternalRemoteDataSource
): ExternalRepository {

    override suspend fun login(id_token: String): Resource<AuthResponse> = ResponseToRequest.send(
        externalRemoteDataSource.login(id_token)
    )

}