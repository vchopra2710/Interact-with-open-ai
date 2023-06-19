package com.app.open.ai.data.model.chat.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsageDto(
    @SerialName("prompt_tokens") val promptTokens: Int,
    @SerialName("completion_tokens") val completionTokens: Int,
    @SerialName("total_tokens") val totalTokens: Int,
)
