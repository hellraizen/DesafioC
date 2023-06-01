package com.dleite.carrefourdev.src.domain.extensions

import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import io.reactivex.Single

fun Single<List<UserList>>.toUserListViewData(): Single<List<UserListViewData>> =
    this.map { users ->
        users.map { user ->
            UserListViewData(
                id = user.id,
                imgUrl = user.imgUrl,
                name = user.name,
            )
        }
    }