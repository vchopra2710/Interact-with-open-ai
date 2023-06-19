package com.app.open.ai.data.mapper

import com.app.open.ai.data.model.chat.response.ChatResponseDto
import com.app.open.ai.data.model.chat.response.ChoiceDto
import com.app.open.ai.data.model.chat.response.MessageDto
import com.app.open.ai.data.model.chat.response.UsageDto
import com.app.open.ai.domain.model.chat.response.ChatResponse
import com.app.open.ai.domain.model.chat.response.Choice
import com.app.open.ai.domain.model.chat.response.Message
import com.app.open.ai.domain.model.chat.response.Usage

fun ChatResponseDto.toDomain(): ChatResponse = ChatResponse(
    id = id,
    obj = obj,
    created = created,
    choice = choiceDto.toDomain(),
    usage = usageDto.toDomain(),
)

private fun List<ChoiceDto>.toDomain(): List<Choice> = this.map {
    Choice(
        index = it.index,
        message = it.message.toDomain(),
        finishReason = it.finishReason,
    )
}

private fun MessageDto.toDomain(): Message = Message(
    role = role,
    content = content,
)

private fun UsageDto.toDomain(): Usage = Usage(
    promptTokens = promptTokens,
    completionTokens = completionTokens,
    totalTokens = totalTokens,
)