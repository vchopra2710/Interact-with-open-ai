package com.app.open.ai.ui.chat

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
import com.app.open.ai.ui.compose.QueryText
import com.app.open.ai.ui.compose.ResponseText

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = hiltViewModel(),
) = Column(
    modifier = Modifier.fillMaxSize(),
) {
    val chatQuery by viewModel.chatText.collectAsState()
    val chatHistory by viewModel.chatHistory.collectAsState()

    ChatView(
        modifier = Modifier.weight(0.9f),
        chatHistory = chatHistory
    )
    InputView(
        value = chatQuery,
        modifier = Modifier.weight(0.1f),
        onValueChange = viewModel::updateChat,
        onSendClick = viewModel::onSendClick,
    )
}

@Composable
private fun ChatView(
    modifier: Modifier = Modifier,
    chatHistory: List<Pair<String, String?>>
) = LazyColumn(
    modifier = modifier
        .fillMaxWidth()
        .padding(24.dp)
) {
    items(chatHistory.count()) {
        val (query, response) = chatHistory[it]
        QueryText(query)
        ResponseText(text = response ?: "")
    }
}