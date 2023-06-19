package com.app.open.ai.domain.model.chat.response

data class Usage(
    val promptTokens: Int,
    val completionTokens: Int,
    val totalTokens: Int,
)
