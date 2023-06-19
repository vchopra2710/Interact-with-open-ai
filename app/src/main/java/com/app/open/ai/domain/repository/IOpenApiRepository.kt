package com.app.open.ai.domain.repository

import com.app.open.ai.data.model.chat.request.ChatRequestDto
import com.app.open.ai.domain.model.chat.response.ChatResponse

interface IOpenApiRepository {
    suspend fun chatResponse(request: ChatRequestDto): ChatResponse
    suspend fun imageResponse()
}