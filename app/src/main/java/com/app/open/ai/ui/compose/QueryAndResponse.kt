package com.app.open.ai.ui.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun QueryText(text: String) = Text(
    text = text,
    color = Color.White.copy(alpha = 0.7f),
)

@Composable
fun ResponseText(text: String) = Text(
    text = text,
    color = Color.White,
)