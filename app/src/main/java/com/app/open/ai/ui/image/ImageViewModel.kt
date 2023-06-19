package com.app.open.ai.ui.image

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor() : ViewModel() {
    private val _imageText = MutableStateFlow("")
    val imageText: StateFlow<String> = _imageText

    fun updateImageText(text: String?) {
        _imageText.update { text ?: "" }
    }
}