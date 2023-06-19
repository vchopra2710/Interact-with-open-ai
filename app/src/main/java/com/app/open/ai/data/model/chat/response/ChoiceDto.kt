package com.app.open.ai.data.model.chat.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChoiceDto(
    @SerialName("index") val index: Int,
    @SerialName("message") val message: MessageDto,
    @SerialName("finish_reason") val finishReason: String,
)
