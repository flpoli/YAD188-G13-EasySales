package com.poli.prevendasomie.di

import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.data.remote.HttpRoutes.LOGIN_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideLoginApi(): BackEndApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(LOGIN_URL)
            .build()
            .create(BackEndApi::class.java)

    }
}