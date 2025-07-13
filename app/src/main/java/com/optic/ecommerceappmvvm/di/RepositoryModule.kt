package com.optic.ecommerceappmvvm.di

import com.optic.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.optic.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSource
import com.optic.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.optic.ecommerceappmvvm.data.dataSource.remote.TeamRemoteDataSource
import com.optic.ecommerceappmvvm.data.dataSource.remote.service.external.ExternalRemoteDataSource
import com.optic.ecommerceappmvvm.data.repository.ExternalRepositoryImpl
import com.optic.ecommerceappmvvm.data.repository.TeamRepositoryImpl
import com.optic.ecommerceappmvvm.domain.repository.AuthRepository
import com.optic.ecommerceappmvvm.domain.repository.ExternalRepository
import com.optic.ecommerceappmvvm.domain.repository.TeamRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)



    @Provides
    fun provideTeamRepository(
        teamRemoteDataSource: TeamRemoteDataSource,
    ): TeamRepository = TeamRepositoryImpl(teamRemoteDataSource)


    @Provides
    fun provideExternalRepository(
        externalRemoteDataSource: ExternalRemoteDataSource,
    ): ExternalRepository = ExternalRepositoryImpl(externalRemoteDataSource)



}