package com.app.open.ai.ui.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun InputView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .height(50.dp)
        .border(
            width = 1.dp,
            color = Color.Gray,
            shape = RoundedCornerShape(4.dp)
        )
        .padding(1.dp),
    contentAlignment = Alignment.TopCenter,
) {
    InputTextField(
        value = value,
        onValueChange = onValueChange,
    )
}

@Composable
private fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
) = TextField(
    value = value,
    onValueChange = onValueChange,
    modifier = Modifier.fillMaxSize(),
    colors = TextFieldDefaults.outlinedTextFieldColors(
        backgroundColor = Color.Black,
        focusedBorderColor = Color.Black,
        unfocusedBorderColor = Color.Black,
        textColor = Color.White
    ),
)