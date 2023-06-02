package com.dleite.carrefourdev.src.domain.extensions

import com.dleite.carrefourdev.src.domain.model.RepositoryGitList
import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData

fun List<RepositoryGitList>.toRepoListViewData(): List<RepoGitListViewData> =
    this.map { repo ->
        RepoGitListViewData(
            id = repo.id,
            forks = repo.forks,
            name = repo.name
        )
    }
