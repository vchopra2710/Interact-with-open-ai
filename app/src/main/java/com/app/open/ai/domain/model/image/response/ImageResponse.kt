package com.app.open.ai.domain.model.image.response

data class ImageResponse(
    val created: Int,
    val data: List<Data>
)