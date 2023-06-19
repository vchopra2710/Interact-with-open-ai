package com.app.open.ai.di

import com.app.open.ai.utils.HttpClientAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPublicHttpClient(): HttpClient = HttpClientAdapter.publicClient()
}