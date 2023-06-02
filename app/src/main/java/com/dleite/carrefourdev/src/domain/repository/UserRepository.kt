package com.dleite.carrefourdev.src.domain.repository

import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import io.reactivex.Single

interface UserRepository {
    suspend fun getUsersList(): List<UserList>

    suspend fun getUser(name: String): User
}
