package com.dleite.carrefourdev.src.data.datasource.remote.service

import com.dleite.carrefourdev.src.data.datasource.remote.model.UserResponse
import com.dleite.carrefourdev.src.data.datasource.remote.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users")
    suspend fun getUsersList(): UsersResponse


    @GET("users/{name}")
    suspend fun getUser(
        @Path("name") name: String
    ): UserResponse

}
