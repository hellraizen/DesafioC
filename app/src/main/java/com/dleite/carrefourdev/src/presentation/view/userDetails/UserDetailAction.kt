package com.dleite.carrefourdev.src.presentation.view.userDetails

import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData
import com.dleite.carrefourdev.src.presentation.model.UserViewData

sealed class UserDetailAction : UIAction {

    data class ShowUser(val users: UserViewData) : UserDetailAction()
    data class ShowRepoGit(val repoGit: List<RepoGitListViewData>) : UserDetailAction()
    data class ShowErrorMessage(val errorMessage: String) : UserDetailAction()
}