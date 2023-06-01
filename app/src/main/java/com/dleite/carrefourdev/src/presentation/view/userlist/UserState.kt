package com.dleite.carrefourdev.src.presentation.view.userlist

import com.dleite.carrefourdev.arch.UIState

data class UserState(
    val isLoading: Boolean = false,
) : UIState
