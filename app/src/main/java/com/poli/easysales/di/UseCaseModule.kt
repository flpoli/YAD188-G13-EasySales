package com.poli.easysales.di

import com.poli.easysales.domain.repository.ClientsRepository
import com.poli.easysales.domain.repository.OrdersRepository
import com.poli.easysales.domain.repository.ProductsRepository
import com.poli.easysales.domain.usecase.UseCases
import com.poli.easysales.domain.usecase.clients.GetClientDetailsUseCase
import com.poli.easysales.domain.usecase.clients.GetClientListForSelectionUseCaseImpl
import com.poli.easysales.domain.usecase.clients.GetClientListUseCaseImpl
import com.poli.easysales.domain.usecase.clients.GetClienteDetailUseCaseImpl
import com.poli.easysales.domain.usecase.clients.GetOrdersForClientImpl
import com.poli.easysales.domain.usecase.clients.IncluirClienteUseCase
import com.poli.easysales.domain.usecase.clients.IncluirClienteUseCaseImpl
import com.poli.easysales.domain.usecase.pedidos.GetOrderDetailImpl
import com.poli.easysales.domain.usecase.pedidos.GetOrdersListUseCaseImpl
import com.poli.easysales.domain.usecase.pedidos.GetProductListForSelectionImpl
import com.poli.easysales.domain.usecase.pedidos.InsertSelectedClientUseCaseImpl
import com.poli.easysales.domain.usecase.products.GetProductsListUseCase
import com.poli.easysales.domain.usecase.products.GetProductsListUseCaseImpl
import com.poli.easysales.domain.usecase.products.GetSelectedProductImpl
import com.poli.easysales.login.domain.repository.LoginRepository
import com.poli.easysales.login.domain.repository.TokenRepository
import com.poli.easysales.login.domain.usecase.CredentialsLoginUseCase
import com.poli.easysales.login.domain.usecase.CredentialsLoginUseCaseImpl
import com.poli.easysales.signup.domain.repository.SignUpRepository
import com.poli.easysales.signup.domain.usecase.SignUpUseCase
import com.poli.easysales.signup.domain.usecase.SignUpUseCaseImpl
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
    fun providesUseCases(r1: ProductsRepository, r2: ClientsRepository, r3: OrdersRepository): UseCases {
        // solução provisória aqui ^
        return UseCases(
            getProductListUseCase = GetProductsListUseCaseImpl(r1),
            getSelectedProduct = GetSelectedProductImpl(r1),
            getOrderDetail = GetOrderDetailImpl(r3),
            getClientListUseCase = GetClientListUseCaseImpl(r2),
            getOrdersListUseCase = GetOrdersListUseCaseImpl(r3),
            getSelectedClientUseCase = GetClienteDetailUseCaseImpl(r2),
            getClientListForSelectionUseCase = GetClientListForSelectionUseCaseImpl(r2),
            insertSelectedClientUseCase = InsertSelectedClientUseCaseImpl(r3),
            getProductListForSelection = GetProductListForSelectionImpl(r1),
            getOrdersForClient = GetOrdersForClientImpl(r2)
        )
    }
}
