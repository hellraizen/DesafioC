package com.dleite.carrefourdev.src.di

import com.dleite.carrefourdev.src.data.datasource.remote.RepositoryGitRemote
import com.dleite.carrefourdev.src.data.datasource.remote.UserRemote
import com.dleite.carrefourdev.src.data.datasource.remote.impl.RepositoryGitRemoteImpl
import com.dleite.carrefourdev.src.data.datasource.remote.impl.UserRemoteImpl
import com.dleite.carrefourdev.src.data.datasource.remote.service.RepositoryGitService
import com.dleite.carrefourdev.src.data.datasource.remote.service.UserService
import com.dleite.carrefourdev.src.data.datasource.repository.RepoGitRepositoryImpl
import com.dleite.carrefourdev.src.data.datasource.repository.UserRepositoryImpl
import com.dleite.carrefourdev.src.domain.repository.RepoGitRepository
import com.dleite.carrefourdev.src.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
interface UserModule {
    @Binds
    fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    fun bindUserRemote(userRemoteImpl: UserRemoteImpl): UserRemote

    @Binds
    fun bindRepoRemote(RepositoryGitRemoteImpl: RepositoryGitRemoteImpl):RepositoryGitRemote

    @Binds
    fun bindRepoRepository(repoGitRepositoryImpl: RepoGitRepositoryImpl): RepoGitRepository


}

@Module
@InstallIn(SingletonComponent::class)
object UserNetworkingModule {

    @Provides
    fun providesUserService(retrofit: Retrofit) : UserService {
        return retrofit.create()
    }

    @Provides
    fun providesReposService(retrofit: Retrofit) : RepositoryGitService {
        return retrofit.create()
    }
}