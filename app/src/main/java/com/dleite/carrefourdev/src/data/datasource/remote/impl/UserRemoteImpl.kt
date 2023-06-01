package com.dleite.carrefourdev.src.data.datasource.remote.impl

import com.dleite.carrefourdev.src.data.datasource.remote.UserRemote
import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse
import com.dleite.carrefourdev.src.data.datasource.remote.service.UserService
import io.reactivex.Single
import javax.inject.Inject

class UserRemoteImpl @Inject constructor(
    private val service: UserService
) : UserRemote {

    override fun fetchUsers(): Single<UsersResponse> =
        service.getUsersList()

    override fun fetchUser(name: String): Single<UserResponse> =
        service.getUser(name)

}
