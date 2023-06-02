package com.dleite.carrefourdev.src.data.datasource.remote

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse

interface UserRemote {
    fun fetchUsers(): Single<UsersResponse>

    suspend fun fetchUser(name: String): UserResponse


}