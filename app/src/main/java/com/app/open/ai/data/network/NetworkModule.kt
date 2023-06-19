package com.app.open.ai.data.network

import android.content.Context
import com.app.open.ai.data.repository.OpenApiRepository
import com.app.open.ai.domain.repository.IOpenApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOpenApiRepository(
        @ApplicationContext context: Context,
        client: HttpClient,
    ): IOpenApiRepository = OpenApiRepository(
        context = context,
        client = client,
    )
}