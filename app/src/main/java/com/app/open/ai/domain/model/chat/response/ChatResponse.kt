package com.app.open.ai.domain.model.chat.response

data class ChatResponse(
    val id: String,
    val obj: String,
    val created: Double,
    val choice: List<Choice>,
    val usage: Usage,
)
