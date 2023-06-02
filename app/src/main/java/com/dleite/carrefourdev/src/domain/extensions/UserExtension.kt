package com.dleite.carrefourdev.src.domain.extensions

import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import com.dleite.carrefourdev.src.presentation.model.UserViewData
import io.reactivex.Single

fun User.toUserViewData():UserViewData = UserViewData(
            id = this.id,
            imgUrl = this.imgUrl,
            name = this.name,
            login = this.login,
            publicRepo = this.publicRepo
        )
