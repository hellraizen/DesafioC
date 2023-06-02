package com.dleite.carrefourdev.src.presentation.view.userDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dleite.carrefourdev.src.domain.usecase.GetRepoGitUseCase
import com.dleite.carrefourdev.src.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class UserDetailViewModel @Inject constructor(
    private val getRepoGitUseCase: GetRepoGitUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _states = MutableStateFlow(UserDetailState(isLoading = true))
    val states: StateFlow<UserDetailState> = _states


    fun getRepoGit(name: String) {
        viewModelScope.launch {
            runCatching {
                getRepoGitUseCase(name)
            }.onSuccess {
                _states.value = _states.value.copy(isLoading = false, repoGitList = it)
            }.onFailure {
                _states.value = _states.value.copy(
                    isLoading = false,
                    repoGitList = emptyList(),
                    errorMessage = "Algo deu errado"
                )
            }
        }
    }

    fun getUser(name: String) {
        viewModelScope.launch {
            runCatching {
                getUserUseCase(name)
            }.onSuccess {
                _states.value = _states.value.copy(isLoading = false, user = it)
            }.onFailure {
                _states.value = _states.value.copy(
                    isLoading = false,
                    repoGitList = emptyList(),
                    errorMessage = "Algo deu errado"
                )
            }
        }
    }
}
