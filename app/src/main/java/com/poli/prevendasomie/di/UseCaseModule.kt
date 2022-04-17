package com.poli.prevendasomie.di

import com.poli.prevendasomie.domain.repository.ClientsRepository
import com.poli.prevendasomie.domain.use_case.clients.GetClientDetailsUseCase
import com.poli.prevendasomie.domain.use_case.clients.GetClienteDetailUseCaseImpl
import com.poli.prevendasomie.domain.use_case.clients.IncluirClienteUseCase
import com.poli.prevendasomie.domain.use_case.clients.IncluirClienteUseCaseImpl
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepository
import com.poli.prevendasomie.login.domain.usecase.CredentialsLoginUseCase
import com.poli.prevendasomie.login.domain.usecase.CredentialsLoginUseCaseImpl
import com.poli.prevendasomie.signup.domain.repository.SignUpRepository
import com.poli.prevendasomie.signup.domain.usecase.SignUpUseCase
import com.poli.prevendasomie.signup.domain.usecase.SignUpUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCredentialsLoginUseCase(login: LoginRepository, token: TokenRepository): CredentialsLoginUseCase {
        return CredentialsLoginUseCaseImpl(login, token)
    }

    @Provides
    @Singleton
    fun provideSignUpUseCase(
        repository: SignUpRepository,
    ): SignUpUseCase {

        return SignUpUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideIncluirClienteUseCase(
        repository: ClientsRepository
    ): IncluirClienteUseCase {

        return IncluirClienteUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetClientDetailsUseCase(repository: ClientsRepository): GetClientDetailsUseCase {

        return GetClienteDetailUseCaseImpl(repository)
    }
}
