package com.dleite.carrefourdev.src.domain.usecase

import com.dleite.carrefourdev.src.domain.extensions.toRepoListViewData
import com.dleite.carrefourdev.src.domain.repository.RepoGitRepository
import com.dleite.carrefourdev.src.presentation.model.RepoGitListViewData
import io.reactivex.Single
import javax.inject.Inject

class GetRepoGitUseCase @Inject constructor(
    private val repoGitRepository: RepoGitRepository
) {
    operator fun invoke(name: String): Single<List<RepoGitListViewData>> {
        return repoGitRepository.getRepositoryGit(name).toRepoListViewData()
    }
}
