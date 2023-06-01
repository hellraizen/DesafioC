package com.dleite.carrefourdev.src.domain.usecase

import com.dleite.carrefourdev.src.domain.extensions.toUserListViewData
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import io.reactivex.Single
import javax.inject.Inject

internal class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Single<List<UserListViewData>> {
        return userRepository.getUsersList().toUserListViewData()
    }
}
