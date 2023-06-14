package com.app.open.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.open.ai.ui.compose.SystemUiController
import com.app.open.ai.ui.home.HomeScreen
import com.app.open.ai.ui.theme.InteractwithopenaiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SystemUiController()
            InteractwithopenaiTheme { HomeScreen() }
        }
    }
}