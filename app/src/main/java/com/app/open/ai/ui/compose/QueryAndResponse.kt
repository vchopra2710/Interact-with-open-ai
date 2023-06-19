package com.app.open.ai.ui.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

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

@Composable
fun ResponseImage(
    url: String,
    modifier: Modifier
) = AsyncImage(
    model = url,
    contentDescription = null,
    modifier = modifier,
    contentScale = ContentScale.FillBounds,
)