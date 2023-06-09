package com.dleite.carrefourdev.src.presentation.view.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dleite.carrefourdev.src.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUserListUseCase,
) : ViewModel() {

    private val _states = MutableStateFlow(UserState(isLoading = true))
    val states: StateFlow<UserState> = _states

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            runCatching {
                getUsersUseCase()
            }.onSuccess {
                _states.value = _states.value.copy(isLoading = false, userList = it)
            }.onFailure {
                _states.value = _states.value.copy(
                    isLoading = false,
                    userList = emptyList(),
                    errorMessage = "Algo deu errado"
                )
            }
        }
    }
}
