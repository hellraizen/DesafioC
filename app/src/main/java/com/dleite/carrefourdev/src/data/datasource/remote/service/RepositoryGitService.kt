package com.dleite.carrefourdev.src.data.datasource.remote.service

import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryGitService {

    @GET("users/{name}/repos")
    suspend fun getRepository(
        @Path("name") name: String
    ):RepositoryGitResponse

}
