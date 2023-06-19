package com.app.open.ai.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.open.ai.domain.model.chat.request.ChatMessage
import com.app.open.ai.domain.model.chat.request.ChatRequest
import com.app.open.ai.domain.usecase.ChatWithOpenAIUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val chatWithOpenAIUseCase: ChatWithOpenAIUseCase,
) : ViewModel() {
    private val _chatText = MutableStateFlow("")
    val chatText: StateFlow<String> = _chatText

    private val _chatHistory = MutableStateFlow<List<Pair<String, String?>>>(listOf())
    val chatHistory: StateFlow<List<Pair<String, String?>>> = _chatHistory

    fun updateChat(text: String?) {
        _chatText.update { text ?: "" }
    }

    fun onSendClick() {
        if (chatText.value.isEmpty()) return

        updateChatHistory(query = chatText.value)


        viewModelScope.launch {
            val chatResponse = chatWithOpenAIUseCase(
                request = ChatRequest(
                    message = listOf(
                        ChatMessage(content = chatText.value),
                    )
                )
            )

            updateChatHistory(
                query = chatText.value,
                response = chatResponse.choice.joinToString(separator = "\n\n") {
                    it.message.content.replace("\n", "")
                },
            )

            _chatText.value = ""
        }
    }

    private fun updateChatHistory(
        query: String,
        response: String? = null,
    ) {
        _chatHistory.update {
            val history = chatHistory.value
                .toMutableList()
                .apply {
                    if (this.isNotEmpty() && this.last().first == query) {
                        val index = this.lastIndex
                        removeAt(index)
                    }
                    add(Pair(query, "\n$response\n\n"))
                }

            history
        }
    }

}