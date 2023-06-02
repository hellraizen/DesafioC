package com.dleite.carrefourdev.src.domain.usecase

import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import com.dleite.carrefourdev.src.presentation.model.UserListViewData
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): List<UserListViewData> {
        return userRepository.getUsersList().toViewDataModel()
    }
}

fun List<UserList>.toViewDataModel() = this.map { user ->
    UserListViewData(
        id = user.id,
        imgUrl = user.imgUrl,
        name = user.name,
    )
}
