package com.poli.prevendasomie.di

import com.poli.prevendasomie.domain.repository.ClientsRepository
import com.poli.prevendasomie.domain.repository.ProductsRepository
import com.poli.prevendasomie.domain.usecase.UseCases
import com.poli.prevendasomie.domain.usecase.clients.GetClientDetailsUseCase
import com.poli.prevendasomie.domain.usecase.clients.GetClienteDetailUseCaseImpl
import com.poli.prevendasomie.domain.usecase.clients.IncluirClienteUseCase
import com.poli.prevendasomie.domain.usecase.clients.IncluirClienteUseCaseImpl
import com.poli.prevendasomie.domain.usecase.pedidos.GetOrdersListUseCaseImpl
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCaseImpl
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

    @Provides
    @Singleton
    fun provideGetProductListUseCase(repository: ProductsRepository): GetProductsListUseCase {

        return GetProductsListUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun providesUseCases(repository: ProductsRepository): UseCases {

        return UseCases(
            getProductListUseCase = GetProductsListUseCaseImpl(repository)

        )
    }
}
