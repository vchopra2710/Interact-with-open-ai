package com.app.open.ai.ui.image

import android.util.Log
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

    fun onSendClick() {
        Log.d("_dbg", "onSendClick: [image]")
    }
}