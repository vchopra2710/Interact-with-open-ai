package com.app.open.ai.data.model.chat.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatResponseDto(
    @SerialName("id") val id: String,
    @SerialName("object") val obj: String,
    @SerialName("created") val created: Double,
    @SerialName("choices") val choiceDto: List<ChoiceDto>,
    @SerialName("usage") val usageDto: UsageDto,
)
