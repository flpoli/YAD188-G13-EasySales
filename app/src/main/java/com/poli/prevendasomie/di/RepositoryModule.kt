package com.poli.prevendasomie.di

import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.login.domain.repository.DemoLoginRepository
import com.poli.prevendasomie.login.domain.repository.DemoTokenRepository
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepository
import com.poli.prevendasomie.signup.domain.repository.SignUpRepository
import com.poli.prevendasomie.signup.domain.repository.SignUpRepositoryImpl
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


    @Binds
    abstract fun bindSignUpRepository(
        signUpRepository: SignUpRepositoryImpl
    ): SignUpRepository



}