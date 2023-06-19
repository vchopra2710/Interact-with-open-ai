package com.app.open.ai.data.mapper

import com.app.open.ai.data.model.image.response.DataDto
import com.app.open.ai.data.model.image.response.ImageResponseDto
import com.app.open.ai.domain.model.image.response.Data
import com.app.open.ai.domain.model.image.response.ImageResponse

fun ImageResponseDto.toDomain(): ImageResponse = ImageResponse(
    created = created,
    data = data.toDomain(),
)

private fun List<DataDto>.toDomain(): List<Data> = this.map {
    Data(url = it.url)
}