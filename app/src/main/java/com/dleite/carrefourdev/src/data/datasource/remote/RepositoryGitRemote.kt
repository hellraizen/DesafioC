package com.dleite.carrefourdev.src.data.datasource.remote

import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse
import io.reactivex.Single

interface RepositoryGitRemote {

    fun fetchRepository(name: String): Single<RepositoryGitResponse>

}