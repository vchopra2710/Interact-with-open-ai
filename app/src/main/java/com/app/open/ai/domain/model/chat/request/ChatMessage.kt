package com.app.open.ai.domain.model.chat.request

data class ChatMessage(
    val role: String="system",
    val content: String
)
