package com.dleite.carrefourdev.src.domain.extensions

import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import com.dleite.carrefourdev.src.presentation.model.UserViewData
import io.reactivex.Single

fun Single<User>.toUserViewData(): Single<UserViewData> =
    this.map { user ->
        UserViewData(
            id = user.id,
            imgUrl = user.imgUrl,
            name = user.name,
            login = user.login,
            publicRepo = user.publicRepo
        )
    }