package com.dleite.carrefourdev.src.presentation.view.userDetails

import com.dleite.carrefourdev.arch.UIState

data class UserDetailState(
    val isLoading: Boolean = false,
) : UIState
