package com.dleite.carrefourdev.src.data.datasource.remote.impl

import com.dleite.carrefourdev.src.data.datasource.remote.RepositoryGitRemote
import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse
import com.dleite.carrefourdev.src.data.datasource.remote.service.RepositoryGitService
import io.reactivex.Single
import javax.inject.Inject

class RepositoryGitRemoteImpl @Inject constructor(
    private val service: RepositoryGitService
) : RepositoryGitRemote {

    override fun fetchRepository(name: String): Single<RepositoryGitResponse> =
        service.getRepository(name)

}
