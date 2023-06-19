package com.app.open.ai.domain.model.chat.request

data class ChatRequest(
    val model: String = "gpt-3.5-turbo",
    val message: List<ChatMessage>,
)
