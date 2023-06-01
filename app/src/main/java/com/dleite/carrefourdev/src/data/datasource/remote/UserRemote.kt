package com.dleite.carrefourdev.src.data.datasource.remote

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse
import io.reactivex.Single

interface UserRemote {
    fun fetchUsers(): Single<UsersResponse>

    fun fetchUser(name: String): Single<UserResponse>


}