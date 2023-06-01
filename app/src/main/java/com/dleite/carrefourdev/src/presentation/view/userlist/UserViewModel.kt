package com.dleite.carrefourdev.src.presentation.view.userlist

import com.dleite.carrefourdev.arch.viewmodel.ViewModel
import com.dleite.carrefourdev.src.domain.extensions.applyIOToMainThread
import com.dleite.carrefourdev.src.domain.usecase.GetUserListUseCase
import com.dleite.carrefourdev.src.presentation.view.userDetails.UserDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUserListUseCase
) : ViewModel<UserDetailState, UserAction>(UserDetailState()) {

    fun getUsers() {
        getUsersUseCase()
            .applyIOToMainThread()
            .doOnSubscribe { setState { it.copy(isLoading = true) } }
            .doAfterTerminate { setState { it.copy(isLoading = false) } }
            .subscribe(
                { users ->
                    sendAction { UserAction.ShowUsers(users) }
                },
                { error ->
                    sendAction { UserAction.ShowErrorMessage(error.message ?: "") }
                }
            ).handleDisposable()
    }
}
