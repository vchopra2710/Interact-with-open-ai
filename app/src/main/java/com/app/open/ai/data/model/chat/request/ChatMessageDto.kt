package com.app.open.ai.data.model.chat.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatMessageDto(
    @SerialName("role") val role: String,
    @SerialName("content") val content: String
)
