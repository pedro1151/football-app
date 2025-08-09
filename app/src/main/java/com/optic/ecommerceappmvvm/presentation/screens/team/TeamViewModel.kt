package com.optic.ecommerceappmvvm.presentation.screens.team

import androidx.lifecycle.ViewModel
import com.optic.ecommerceappmvvm.domain.useCase.team.TeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.optic.ecommerceappmvvm.domain.model.Team
import com.optic.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamUseCase: TeamUseCase
) : ViewModel() {

    private val _teamState =  MutableStateFlow<Resource<Team>>(Resource.Loading)
    val teamState: StateFlow<Resource<Team>> = _teamState



    fun getTeamById(teamId: Int) {
        viewModelScope.launch {
            teamUseCase.getTeamByIdUC(teamId).collectLatest { result ->
                _teamState.value = result
            }
        }
    }
}