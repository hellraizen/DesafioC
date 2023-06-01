package com.dleite.carrefourdev.src.data.datasource.remote.service

import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryGitService {

    @GET("users/{name}/repos")
    fun getRepository(
        @Path("name") name: String
    ): Single<RepositoryGitResponse>

}
