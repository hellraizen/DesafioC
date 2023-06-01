package com.dleite.carrefourdev.src.domain.extensions

import com.dleite.carrefourdev.src.domain.model.RepositoryGitList
import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData
import io.reactivex.Single

fun Single<List<RepositoryGitList>>.toRepoListViewData(): Single<List<RepoGitListViewData>> =
    this.map { repos ->
        repos.map { repo ->
            RepoGitListViewData(
                id = repo.id,
                forks = repo.forks,
                name = repo.name
            )
        }
    }