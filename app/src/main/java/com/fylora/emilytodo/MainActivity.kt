package com.fylora.emilytodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.fylora.emilytodo.presentation.tasks.TaskScreen
import com.fylora.emilytodo.presentation.ui.theme.EmilyTodoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmilyTodoTheme {
                TaskScreen()
            }
        }
    }
}

