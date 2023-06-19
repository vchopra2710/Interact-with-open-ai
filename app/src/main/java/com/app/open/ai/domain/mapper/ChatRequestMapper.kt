package com.app.open.ai.domain.mapper

import com.app.open.ai.data.model.chat.request.ChatMessageDto
import com.app.open.ai.data.model.chat.request.ChatRequestDto
import com.app.open.ai.domain.model.chat.request.ChatMessage
import com.app.open.ai.domain.model.chat.request.ChatRequest

fun ChatRequest.toDto(): ChatRequestDto = ChatRequestDto(
    model = model,
    message = message.toDto(),
)

private fun List<ChatMessage>.toDto(): List<ChatMessageDto> = this.map {
    ChatMessageDto(
        role = it.role,
        content = it.content,
    )
}