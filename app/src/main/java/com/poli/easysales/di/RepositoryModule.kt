package com.poli.easysales.di

import android.app.Application
import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.google.gson.Gson
import com.poli.easysales.common.Constants.DATA_BASE_NAME
import com.poli.easysales.data.local.DatabaseConverter
import com.poli.easysales.data.local.ErpDatabase
import com.poli.easysales.data.local.dao.UserDao
import com.poli.easysales.data.remote.BackEndApi
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.repository.ClientsRepositoryImpl
import com.poli.easysales.data.repository.LocalDataSourceImpl
import com.poli.easysales.data.repository.OrdersRepositoryImpl
import com.poli.easysales.data.repository.ProductsRepositoryImpl
import com.poli.easysales.data.repository.RemoteDataSourceImpl
import com.poli.easysales.data.util.GsonParser
import com.poli.easysales.domain.repository.ClientsRepository
import com.poli.easysales.domain.repository.LocalDataSource
import com.poli.easysales.domain.repository.OrdersRepository
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.domain.repository.ProductsRepository
import com.poli.easysales.domain.repository.RemoteDataSource
import com.poli.easysales.login.domain.repository.LoginRepository
import com.poli.easysales.login.domain.repository.LoginRepositoryImpl
import com.poli.easysales.login.domain.repository.TokenRepository
import com.poli.easysales.login.domain.repository.TokenRepositoryImpl
import com.poli.easysales.signup.domain.repository.SignUpRepository
import com.poli.easysales.signup.domain.repository.SignUpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@ExperimentalPagingApi
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): ErpDatabase {

        return Room.databaseBuilder(
            app,
            ErpDatabase::class.java,
            DATA_BASE_NAME
        )
            .addTypeConverter(DatabaseConverter(GsonParser(Gson())))
            .setQueryCallback(
                {
                        sqlQuery, bindArgs ->
                    Log.i("SQL Query: ", "$sqlQuery SQL Args: $bindArgs")
                },
                Executors.newSingleThreadExecutor()
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: ErpDatabase) = db.userDao()

    @Provides
    @Singleton
    fun provideLoginRepository(api: BackEndApi, dao: UserDao, preferences: Preferences): LoginRepository {
        return LoginRepositoryImpl(api, dao, preferences)
    }

    @Provides
    @Singleton
    fun provideTokenRepository(dataStore: Preferences): TokenRepository {
        return TokenRepositoryImpl(dataStore)
    }
    @Provides
    @Singleton
    fun provideSignUpRepository(api: BackEndApi): SignUpRepository {
        return SignUpRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(api: OmieAPI, db: ErpDatabase): RemoteDataSource {
        return RemoteDataSourceImpl(api, db)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(db: ErpDatabase): LocalDataSource {

        return LocalDataSourceImpl(db)
    }
    /* ****************************************************** */

    @Provides
    @Singleton
    fun provideClientsRepository(api: OmieAPI, remote: RemoteDataSource, local: LocalDataSource):
        ClientsRepository {

        return ClientsRepositoryImpl(api, remote, local)
    }
    @Provides
    @Singleton
    fun provideProductsRepository(remote: RemoteDataSource, local: LocalDataSource): ProductsRepository {

        return ProductsRepositoryImpl(remote, local)
    }
    @Provides
    @Singleton
    fun provideOrdersRepository(local: LocalDataSource, remote: RemoteDataSource, api: OmieAPI):
        OrdersRepository {

        return OrdersRepositoryImpl(api, remote, local)
    }

    /*******************************************************/
}
