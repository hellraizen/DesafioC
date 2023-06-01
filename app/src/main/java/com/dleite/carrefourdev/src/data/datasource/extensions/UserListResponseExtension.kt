package com.dleite.carrefourdev.src.data.datasource.extensions

import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse
import com.dleite.carrefourdev.src.domain.model.UserList
import io.reactivex.Single

fun Single<UsersResponse>.toListOfUserList(): Single<List<UserList>> =
    this.map { users ->
        users.map { user ->
            UserList(
                id = user.id.toString() ,
                imgUrl = user.avatarUrl ,
                name = user.login
            )
        }
    }

