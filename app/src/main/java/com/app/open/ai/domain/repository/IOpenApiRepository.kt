package com.app.open.ai.domain.repository

import com.app.open.ai.data.model.chat.request.ChatRequestDto
import com.app.open.ai.data.model.image.request.ImageRequestDto
import com.app.open.ai.domain.model.chat.response.ChatResponse
import com.app.open.ai.domain.model.image.response.ImageResponse

interface IOpenApiRepository {
    suspend fun chatResponse(request: ChatRequestDto): ChatResponse
    suspend fun imageResponse(request: ImageRequestDto): ImageResponse
}