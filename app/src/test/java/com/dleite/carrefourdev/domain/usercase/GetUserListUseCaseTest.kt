package com.dleite.carrefourdev.domain.usercase

import com.dleite.carrefourdev.common.test.BaseUnitTest
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import com.dleite.carrefourdev.src.domain.usecase.GetUserListUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test


class GetUserListUseCaseTest:BaseUnitTest() {

    private val userRepository: UserRepository by lazy { mockk() }

    private val getUserListUseCase by lazy {
        GetUserListUseCase(userRepository)
    }

    @Test(expected = DefaultNetworkError::class)
    fun `SHOULD GetUserListUseCase be successful`() {
        coEvery { userRepository.getUsersList() } throws DefaultNetworkError(null)
        runBlocking { getUserListUseCase() }
        coVerify(exactly = 1) { userRepository.getUsersList() }


    }

    @Test(expected = DefaultNetworkError::class)
    fun `SHOULD GetUserListUseCase fail`() {
        coEvery { userRepository.getUsersList() } throws DefaultNetworkError(null)
        runBlocking { getUserListUseCase() }
        coVerify(exactly = 0) { userRepository.getUsersList() }
    }
}
class DefaultNetworkError(cause: Throwable?) : Throwable("Something went wrong", cause)



