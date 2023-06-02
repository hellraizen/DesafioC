package com.dleite.carrefourdev.src.data.datasource.repository

import com.dleite.carrefourdev.src.data.datasource.extensions.toOfUser
import com.dleite.carrefourdev.src.data.datasource.remote.UserRemote
import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemote
) : UserRepository {

    override suspend fun getUsersList(): List<UserList> =
        remoteDataSource.fetchUsers().map { user ->
            UserList(
                id = user.id.toString(),
                imgUrl = user.avatarUrl,
                name = user.login
            )
        }

    override suspend fun getUser(name: String): User =
        remoteDataSource.fetchUser(name).toOfUser()

}



