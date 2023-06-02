package com.dleite.carrefourdev.domain.usercase

import com.dleite.carrefourdev.common.test.BaseUnitTest
import com.dleite.carrefourdev.src.domain.model.UserList
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import com.dleite.carrefourdev.src.domain.usecase.GetUserListUseCase
import com.dleite.carrefourdev.src.domain.usecase.toViewDataModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test


class GetUserListUseCaseTest : BaseUnitTest() {

    private val userRepository: UserRepository by lazy { mockk() }

    private val getUserListUseCase by lazy {
        GetUserListUseCase(userRepository)
    }

    @Test
    fun `SHOULD GetUserListUseCase be successful`() = runBlocking {
        val expectedResult = listOf(
            UserList(
                id = "1",
                imgUrl = "1",
                name = "1"
            ),
            UserList(
                id = "2",
                imgUrl = "2",
                name = "2"
            )
        )
        coEvery { userRepository.getUsersList() } returns expectedResult
        val result = getUserListUseCase()
        coVerify(exactly = 1) { userRepository.getUsersList() }
        assertEquals(expectedResult.toViewDataModel(), result)
    }

    @Test(expected = DefaultNetworkError::class)
    fun `SHOULD GetUserListUseCase fail`() {
        coEvery { userRepository.getUsersList() } throws DefaultNetworkError(null)
        runBlocking { getUserListUseCase() }
    }
}
class DefaultNetworkError(cause: Throwable?) : Throwable("Something went wrong", cause)



