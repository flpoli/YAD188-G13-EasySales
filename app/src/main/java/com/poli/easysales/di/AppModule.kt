package com.poli.easysales.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.poli.easysales.common.Constants.BASE_ERP_URL
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.repository.DefaultPreferences
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.domain.usecase.UseCases
import com.poli.easysales.domain.usecase.pedidos.CreateNewOrderUseCaseImpl
import com.poli.easysales.presentation.pedidos.OrdersFormViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    private val gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOmieApi(client: OkHttpClient): OmieAPI {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_ERP_URL)
            .client(client)
            .build()
            .create(OmieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideOrderViewModel(useCase: UseCases): OrdersFormViewModel {

        return OrdersFormViewModel(useCase)

    }
}
