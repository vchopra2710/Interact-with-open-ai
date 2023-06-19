package com.app.open.ai.ui.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.open.ai.ui.compose.InputView
import com.app.open.ai.ui.compose.QueryText
import com.app.open.ai.ui.compose.ResponseImage

@Composable
fun ImageScreen(
    viewModel: ImageViewModel = hiltViewModel(),
) = Column(
    modifier = Modifier.fillMaxSize(),
) {
    val imageQuery by viewModel.imageText.collectAsState()
    val imageHistory by viewModel.chatHistory.collectAsState()

    ImageView(
        modifier = Modifier.weight(0.9f),
        chatHistory = imageHistory,
    )
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
    chatHistory: List<Pair<String, List<String>?>>
) = LazyColumn(
    modifier = modifier
        .fillMaxWidth()
        .padding(24.dp)
) {
    items(chatHistory.count()) {
        val (query, urls) = chatHistory[it]

        QueryText(query)

        Spacer(modifier = Modifier.height(12.dp))

        urls?.forEach { url ->
            ResponseImage(
                url = url,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

    }
}