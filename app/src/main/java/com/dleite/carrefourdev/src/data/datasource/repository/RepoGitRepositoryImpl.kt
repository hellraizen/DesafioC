package com.dleite.carrefourdev.src.data.datasource.repository

import com.dleite.carrefourdev.src.data.datasource.extensions.toListOfRepositoryGit
import com.dleite.carrefourdev.src.data.datasource.remote.RepositoryGitRemote
import com.dleite.carrefourdev.src.domain.model.RepositoryGitList
import com.dleite.carrefourdev.src.domain.repository.RepoGitRepository
import javax.inject.Inject

class RepoGitRepositoryImpl @Inject constructor(
    private val remoteDataSource: RepositoryGitRemote
) : RepoGitRepository {

   override suspend fun getRepositoryGit(name: String):List<RepositoryGitList> =
        remoteDataSource.fetchRepository(name).toListOfRepositoryGit()

}