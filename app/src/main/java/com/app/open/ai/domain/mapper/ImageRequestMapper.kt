package com.app.open.ai.domain.mapper

import com.app.open.ai.data.model.image.request.ImageRequestDto
import com.app.open.ai.domain.model.image.request.ImageRequest

fun ImageRequest.toDto(): ImageRequestDto = ImageRequestDto(
    prompt = prompt,
    count = count,
    size = size,
)