package com.app.open.ai.data.model.image.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataDto(
    @SerialName("url") val url: String
)