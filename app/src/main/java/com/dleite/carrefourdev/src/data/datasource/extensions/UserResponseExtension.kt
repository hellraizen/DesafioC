package com.dleite.carrefourdev.src.data.datasource.extensions

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.domain.model.User

fun UserResponse.toOfUser(): User =
    User(
        id = this.id.toString(),
        imgUrl = this.avatarUrl,
        name = this.name,
        login = this.login,
        publicRepo = this.publicRepos
    )



