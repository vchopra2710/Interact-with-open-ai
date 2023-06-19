package com.app.open.ai.data.model.image.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageResponseDto(
    @SerialName("created") val created: Int,
    @SerialName("data") val data: List<DataDto>
)