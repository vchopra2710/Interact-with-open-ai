package com.app.open.ai.data.network

import com.app.open.ai.BuildConfig

object OpenAIApiRoutes {
    private const val BASE_URL = BuildConfig.BASE_URL
    const val CHAT_URL = "$BASE_URL/chat/completions"
    const val IMAGE_URL = "$BASE_URL/images/generations"

    const val CONNECT_OPEN_AI_BE = false
}