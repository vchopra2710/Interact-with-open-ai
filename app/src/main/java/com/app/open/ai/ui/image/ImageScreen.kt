package com.app.open.ai.ui.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.open.ai.ui.compose.InputView

@Composable
fun ImageScreen(
    viewModel: ImageViewModel = hiltViewModel(),
) = Column(
    modifier = Modifier.fillMaxSize(),
) {
    val imageQuery by viewModel.imageText.collectAsState()

    ImageView(modifier = Modifier.weight(0.9f))
    InputView(
        value = imageQuery,
        modifier = Modifier.weight(0.1f),
        onValueChange = viewModel::updateImageText,
        onSendClick = viewModel::onSendClick,
    )
}

@Composable
private fun ImageView(
    modifier: Modifier = Modifier,
) = LazyColumn(
    modifier = modifier
        .fillMaxWidth()
        .padding(24.dp)
) {

}