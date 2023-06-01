package com.dleite.carrefourdev.src.data.datasource.remote.service

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {


    @GET("users")
    fun getUsersList(): Single<UsersResponse>


    @GET("users/{name}")
    fun getUser(
        @Path("name") name: String
    ): Single<UserResponse>

}
