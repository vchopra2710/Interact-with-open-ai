package com.app.open.ai.domain.usecase

import com.app.open.ai.domain.mapper.toDto
import com.app.open.ai.domain.model.chat.request.ChatRequest
import com.app.open.ai.domain.model.chat.response.ChatResponse
import com.app.open.ai.domain.repository.IOpenApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatWithOpenAIUseCase @Inject constructor(
    private val repository: IOpenApiRepository
) {
    suspend operator fun invoke(
        request: ChatRequest,
    ): ChatResponse = withContext(Dispatchers.IO) {
        repository.chatResponse(request = request.toDto())
    }
}