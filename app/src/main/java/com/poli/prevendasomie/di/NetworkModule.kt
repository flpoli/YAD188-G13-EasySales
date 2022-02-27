package com.poli.prevendasomie.di

import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.data.remote.HttpRoutes.LOGIN_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

    }

    @Singleton
    @Provides
    fun provideLoginApi(client: OkHttpClient): BackEndApi {

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(LOGIN_URL)
            .client(client)
            .build()
            .create(BackEndApi::class.java)

    }
}