package com.dleite.carrefourdev.src.domain.repository

import com.dleite.carrefourdev.src.domain.model.RepositoryGitList

interface RepoGitRepository {

   suspend fun getRepositoryGit(name: String): List<RepositoryGitList>
}
