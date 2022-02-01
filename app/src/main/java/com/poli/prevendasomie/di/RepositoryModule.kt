package com.poli.prevendasomie.di

import com.poli.prevendasomie.login.domain.repository.DemoLoginRepository
import com.poli.prevendasomie.login.domain.repository.DemoTokenRepository
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoginRepository(
        loginRepository: DemoLoginRepository,
    ): LoginRepository

    @Binds
    abstract fun bindTokenRepository(
        tokenRepository: DemoTokenRepository,
    ): TokenRepository

}