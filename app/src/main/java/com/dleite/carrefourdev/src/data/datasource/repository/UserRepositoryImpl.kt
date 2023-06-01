package com.dleite.carrefourdev.src.data.datasource.repository

import com.dleite.carrefourdev.src.data.datasource.extensions.toListOfUserList
import com.dleite.carrefourdev.src.data.datasource.extensions.toOfUser
import com.dleite.carrefourdev.src.data.datasource.remote.UserRemote
import com.dleite.carrefourdev.src.domain.model.User
import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemote
) : UserRepository {

    override fun getUsersList(): Single<List<UserList>> =
        remoteDataSource.fetchUsers().toListOfUserList()
            .onErrorResumeNext { throwable -> Single.error(throwable) }

    override fun getUser(name: String): Single<User> =
        remoteDataSource.fetchUser(name).toOfUser()
            .onErrorResumeNext { throwable -> Single.error(throwable) }
}