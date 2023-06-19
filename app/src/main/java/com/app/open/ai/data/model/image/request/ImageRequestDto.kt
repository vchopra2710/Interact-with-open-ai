package com.app.open.ai.data.model.image.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageRequestDto(
    @SerialName("prompt") val prompt: String,
    @SerialName("n") val count: Int = 2,
    @SerialName("size") val size: String = "1024x1024"
)
