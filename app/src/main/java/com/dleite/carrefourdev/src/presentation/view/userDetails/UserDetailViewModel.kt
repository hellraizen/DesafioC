package com.dleite.carrefourdev.src.presentation.view.userDetails

import com.dleite.carrefourdev.arch.viewmodel.ViewModel
import com.dleite.carrefourdev.src.domain.extensions.applyIOToMainThread
import com.dleite.carrefourdev.src.domain.usecase.GetRepoGitUseCase
import com.dleite.carrefourdev.src.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class UserDetailViewModel @Inject constructor(
    private val getRepoGitUseCase: GetRepoGitUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel<UserDetailState, UserDetailAction>(UserDetailState()) {

    fun getRepoGit(name: String) {
        getRepoGitUseCase(name)
            .applyIOToMainThread()
            .doOnSubscribe { setState { it.copy(isLoading = true) } }
            .doAfterTerminate { setState { it.copy(isLoading = false) } }
            .subscribe(
                { repoGit ->
                    sendAction { UserDetailAction.ShowRepoGit(repoGit) }
                },
                { error ->
                    sendAction { UserDetailAction.ShowErrorMessage(error.message ?: "") }
                }
            ).handleDisposable()
    }

    fun getUser(name: String) {
        getUserUseCase(name)
            .applyIOToMainThread()
            .doOnSubscribe { setState { it.copy(isLoading = true) } }
            .doAfterTerminate { setState { it.copy(isLoading = false) } }
            .subscribe(
                { user ->
                    sendAction { UserDetailAction.ShowUser(user) }
                },
                { error ->
                    sendAction { UserDetailAction.ShowErrorMessage(error.message ?: "") }
                }
            ).handleDisposable()
    }
}
