package com.android.weatherapplication.di

import com.android.weatherapplication.data.source.ApiService
import com.android.weatherapplication.data.source.RemoteDataSourceImpl
import com.android.weatherapplication.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDataSource(
        apiService: ApiService
    ) : RemoteDataSource = RemoteDataSourceImpl(apiService)
}
