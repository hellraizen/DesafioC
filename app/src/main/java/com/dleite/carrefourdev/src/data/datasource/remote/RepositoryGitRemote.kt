package com.dleite.carrefourdev.src.data.datasource.remote

import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse

interface RepositoryGitRemote {

    suspend fun fetchRepository(name: String): RepositoryGitResponse

}