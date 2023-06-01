package com.dleite.carrefourdev.src.presentation.view.userlist

import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import com.dleite.carrefourdev.src.presentation.view.userDetails.UserDetailAction

internal sealed class UserAction : UIAction {

    data class ShowUsers(val users: List<UserListViewData>) : UserAction()
    data class ShowErrorMessage(val errorMessage: String) : UserAction()
}