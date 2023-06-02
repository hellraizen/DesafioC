package com.dleite.carrefourdev.src.data.datasource.extensions

import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse
import com.dleite.carrefourdev.src.domain.model.RepositoryGitList

fun RepositoryGitResponse.toListOfRepositoryGit(): List<RepositoryGitList> =
    this.map { repo ->
        RepositoryGitList(
            id = repo.id.toString(),
            forks = repo.forks,
            name = repo.name
        )
    }


