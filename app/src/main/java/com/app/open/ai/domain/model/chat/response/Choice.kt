package com.app.open.ai.domain.model.chat.response

data class Choice(
    val index: Int,
    val message: Message,
    val finishReason: String,
)
