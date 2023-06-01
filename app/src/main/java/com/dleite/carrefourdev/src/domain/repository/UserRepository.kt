package com.dleite.carrefourdev.src.domain.repository

import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import io.reactivex.Single

interface UserRepository {
    fun getUsersList(): Single<List<UserList>>

    fun getUser(name: String): Single<User>
}
