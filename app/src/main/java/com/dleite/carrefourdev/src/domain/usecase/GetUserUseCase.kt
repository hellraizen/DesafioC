package com.dleite.carrefourdev.src.domain.usecase

import com.dleite.carrefourdev.src.domain.extensions.toUserViewData
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import com.dleite.carrefourdev.src.presentation.model.UserViewData
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(name: String): UserViewData {
        return userRepository.getUser(name).toUserViewData()
    }
}
