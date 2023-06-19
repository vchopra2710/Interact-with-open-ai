package com.app.open.ai.ui.chat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor() : ViewModel() {
    private val _chatText = MutableStateFlow("")
    val chatText: StateFlow<String> = _chatText

    fun updateChat(text: String?) {
        _chatText.update { text ?: "" }
    }

}