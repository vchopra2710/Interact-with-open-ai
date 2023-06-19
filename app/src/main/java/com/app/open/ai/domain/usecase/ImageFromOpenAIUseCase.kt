package com.app.open.ai.domain.usecase

import com.app.open.ai.domain.mapper.toDto
import com.app.open.ai.domain.model.image.request.ImageRequest
import com.app.open.ai.domain.model.image.response.ImageResponse
import com.app.open.ai.domain.repository.IOpenApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageFromOpenAIUseCase @Inject constructor(
    private val repository: IOpenApiRepository
) {
    suspend operator fun invoke(
        request: ImageRequest,
    ): ImageResponse = withContext(Dispatchers.IO) {
        repository.imageResponse(request = request.toDto())
    }
}