package com.app.open.ai.data.model.chat.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatRequestDto(
    @SerialName("model") val model: String,
    @SerialName("messages") val message: List<ChatMessageDto>
)
