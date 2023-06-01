package com.dleite.carrefourdev.src.data.datasource.extensions

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.domain.model.User
import io.reactivex.Single

fun Single<UserResponse>.toOfUser(): Single<User> =
    this.map { user ->
        User(
            id = user.id.toString(),
            imgUrl = user.avatarUrl,
            name = user.name,
            login = user.login,
            publicRepo = user.publicRepos
        )

    }

