package com.dleite.carrefourdev.src.domain.repository

import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import io.reactivex.Single

interface UserRepository {
    fun getUsersList(): Single<List<UserList>>

    suspend fun getUser(name: String): User
}
