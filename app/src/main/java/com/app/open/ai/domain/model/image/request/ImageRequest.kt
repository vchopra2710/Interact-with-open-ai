package com.app.open.ai.domain.model.image.request

data class ImageRequest(
    val prompt: String,
    val count: Int = 2,
    val size: String = "256x256"
)
