package com.app.open.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.app.open.ai.ui.compose.SystemUiController
import com.app.open.ai.ui.theme.InteractwithopenaiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SystemUiController()
            InteractwithopenaiTheme { Text(text = "Hello") }
        }
    }
}