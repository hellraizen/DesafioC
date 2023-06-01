package com.dleite.carrefourdev.src.data.datasource.extensions

import com.dleite.carrefourdev.src.data.datasource.remote.model.RepositoryGitResponse
import com.dleite.carrefourdev.src.domain.model.RepositoryGitList
import io.reactivex.Single

fun Single<RepositoryGitResponse>.toListOfRepositoryGit(): Single<List<RepositoryGitList>> =
    this.map { repos->
        repos.map { repo ->
            RepositoryGitList(
                id = repo.id.toString() ,
                forks = repo.forks ,
                name = repo.name
            )
        }
    }

