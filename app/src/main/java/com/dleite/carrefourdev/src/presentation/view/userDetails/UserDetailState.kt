package com.dleite.carrefourdev.src.presentation.view.userDetails

import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData
import com.dleite.carrefourdev.src.presentation.model.UserViewData

data class UserDetailState(
    val isLoading: Boolean = true,
    val repoGitList: List<RepoGitListViewData> = emptyList(),
    val user: UserViewData = UserViewData(),
    val errorMessage: String = "",
)
