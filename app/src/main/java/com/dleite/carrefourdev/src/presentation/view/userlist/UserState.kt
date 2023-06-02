package com.dleite.carrefourdev.src.presentation.view.userlist

import com.dleite.carrefourdev.src.presentation.model.UserListViewData


data class UserState(
    val isLoading: Boolean = true,
    val userList: List<UserListViewData> = emptyList(),
    val errorMessage: String = "",
)
