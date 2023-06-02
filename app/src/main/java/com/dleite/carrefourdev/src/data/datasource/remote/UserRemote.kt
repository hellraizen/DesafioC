package com.dleite.carrefourdev.src.data.datasource.remote

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse

interface UserRemote {
    suspend fun fetchUsers(): UsersResponse

    suspend fun fetchUser(name: String): UserResponse


}