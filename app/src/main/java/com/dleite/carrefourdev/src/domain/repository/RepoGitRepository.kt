package com.dleite.carrefourdev.src.domain.repository

import com.dleite.carrefourdev.src.domain.model.RepositoryGitList
import io.reactivex.Single

interface RepoGitRepository {

    fun getRepositoryGit(name: String): Single<List<RepositoryGitList>>
}
