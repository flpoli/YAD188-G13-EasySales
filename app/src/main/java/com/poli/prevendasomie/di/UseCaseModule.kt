package com.poli.prevendasomie.di

import com.poli.prevendasomie.login.domain.usecase.CredentialsLoginUseCase
import com.poli.prevendasomie.login.domain.usecase.CredentialsLoginUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindCredentialsLoginUseCase(
        credentialsLoginUseCase: CredentialsLoginUseCaseImpl
    ): CredentialsLoginUseCase


}