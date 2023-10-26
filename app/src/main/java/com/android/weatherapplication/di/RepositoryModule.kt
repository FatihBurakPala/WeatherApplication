package com.android.weatherapplication.di

import com.android.weatherapplication.data.repository.WeatherRepositoryImpl
import com.android.weatherapplication.domain.repository.WeatherRepository
import com.android.weatherapplication.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesCharacterRepository(
        remoteDataSource: RemoteDataSource
    ) : WeatherRepository = WeatherRepositoryImpl(remoteDataSource)
}
