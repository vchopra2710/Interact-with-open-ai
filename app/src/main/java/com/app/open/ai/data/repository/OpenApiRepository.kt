package com.app.open.ai.data.repository

import android.content.Context
import com.app.open.ai.BuildConfig
import com.app.open.ai.R
import com.app.open.ai.data.mapper.toDomain
import com.app.open.ai.data.model.chat.request.ChatRequestDto
import com.app.open.ai.data.model.chat.response.ChatResponseDto
import com.app.open.ai.data.network.OpenAIApiRoutes.CHAT_URL
import com.app.open.ai.data.network.OpenAIApiRoutes.CONNECT_OPEN_AI_BE
import com.app.open.ai.domain.model.chat.response.ChatResponse
import com.app.open.ai.domain.repository.IOpenApiRepository
import com.app.open.ai.utils.readJsonFile
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json
import javax.inject.Inject

class OpenApiRepository @Inject constructor(
    private val context: Context,
    private val client: HttpClient,
) : IOpenApiRepository {

    private val json = Json {
        explicitNulls = false
    }

    override suspend fun chatResponse(request: ChatRequestDto): ChatResponse {
        return if (CONNECT_OPEN_AI_BE) {
            client.post {
                url(CHAT_URL)
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                    append(HttpHeaders.Authorization, "Bearer ${BuildConfig.OPEN_AI_API_KEY}")
                }
                setBody(request)
            }.body<ChatResponseDto>()
        } else {
            val chatString = context.readJsonFile(id = R.raw.chat)
            json.decodeFromString<ChatResponseDto>(chatString)
        }.toDomain()
    }

    override suspend fun imageResponse() {
        TODO("Not yet implemented")
    }
}