package com.optic.ecommerceappmvvm.di

import com.optic.ecommerceappmvvm.domain.repository.AuthRepository
import com.optic.ecommerceappmvvm.domain.repository.ExternalRepository
import com.optic.ecommerceappmvvm.domain.repository.TeamRepository
import com.optic.ecommerceappmvvm.domain.useCase.auth.*
import com.optic.ecommerceappmvvm.domain.useCase.external.ExternalUseCase
import com.optic.ecommerceappmvvm.domain.useCase.external.LoginGoogleUseCase
import com.optic.ecommerceappmvvm.domain.useCase.team.CreateFollowedPlayerUC
import com.optic.ecommerceappmvvm.domain.useCase.team.CreateFollowedTeamUC
import com.optic.ecommerceappmvvm.domain.useCase.team.DeleteFollowedPlayerUC
import com.optic.ecommerceappmvvm.domain.useCase.team.DeleteFollowedTeamUC
import com.optic.ecommerceappmvvm.domain.useCase.team.GetFollowedPlayersUC
import com.optic.ecommerceappmvvm.domain.useCase.team.GetFollowedTeamsUC
import com.optic.ecommerceappmvvm.domain.useCase.team.GetLeaguesUseCase
import com.optic.ecommerceappmvvm.domain.useCase.team.GetPlayerStatsUseCase
import com.optic.ecommerceappmvvm.domain.useCase.team.GetPlayersUseCase
import com.optic.ecommerceappmvvm.domain.useCase.team.GetallTeamUseCase
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import com.optic.ecommerceappmvvm.domain.useCase.team.fixture.GetFixtureFollowedTeamsUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository)
    )

    @Provides
    fun provideTeamUseCase(teamRepository: TeamRepository) = TeamUseCase(
        getallTeamUseCase = GetallTeamUseCase(teamRepository),
        getPlayersUseCase = GetPlayersUseCase(teamRepository),
        getPlayerStatsUseCase = GetPlayerStatsUseCase(teamRepository),
        getLeaguesUseCase = GetLeaguesUseCase(teamRepository),
        getFollowedPlayersUC = GetFollowedPlayersUC(teamRepository),
        createFollowedPlayerUC = CreateFollowedPlayerUC(teamRepository),
        deleteFollowedPlayerUC = DeleteFollowedPlayerUC(teamRepository),

        getFollowedTeamsUC = GetFollowedTeamsUC(teamRepository),
        createFollowedTeamUC = CreateFollowedTeamUC(teamRepository),
        deleteFollowedTeamUC =   DeleteFollowedTeamUC(teamRepository),
        getFixtureFollowedTeamsUC = GetFixtureFollowedTeamsUC(teamRepository)

    )

    @Provides
    fun provideExternalUseCase(externalRepository: ExternalRepository) = ExternalUseCase(
        login = LoginGoogleUseCase(externalRepository)
    )







}