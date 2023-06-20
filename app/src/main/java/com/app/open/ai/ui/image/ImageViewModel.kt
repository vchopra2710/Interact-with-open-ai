package com.app.open.ai.ui.image

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.open.ai.domain.model.image.request.ImageRequest
import com.app.open.ai.domain.usecase.ImageFromOpenAIUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val imageFromOpenAIUseCase: ImageFromOpenAIUseCase,
) : ViewModel() {
    private val _imageText = MutableStateFlow("")
    val imageText: StateFlow<String> = _imageText

    private val _chatHistory = MutableStateFlow<List<Pair<String, List<String>?>>>(listOf())
    val chatHistory: StateFlow<List<Pair<String, List<String>?>>> = _chatHistory

    fun updateImageText(text: String?) {
        _imageText.update { text ?: "" }
    }

    fun onSendClick() {
        if (imageText.value.isEmpty()) return

        updateChatHistory(query = imageText.value)

        viewModelScope.launch {
            val imageResponse = imageFromOpenAIUseCase(
                request = ImageRequest(
                    prompt = imageText.value
                )
            )

            updateChatHistory(
                query = imageText.value,
                response = imageResponse.data.map { it.url },
            )

            updateImageText(null)
        }
    }

    private fun updateChatHistory(
        query: String,
        response: List<String>? = null,
    ) {
        _chatHistory.update {
            val history = chatHistory.value
                .toMutableList()
                .apply {
                    if (this.isNotEmpty() && this.last().first == query) {
                        val index = this.lastIndex
                        removeAt(index)
                    }
                    add(Pair(query, response))
                }

            history
        }
    }
}