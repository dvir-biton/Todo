package com.fylora.emilytodo.presentation.tasks


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fylora.emilytodo.presentation.tasks.components.TaskComponent


@Composable
fun TaskScreen(
    viewModel: TaskViewModel = hiltViewModel()
) {
    val snackbarHost = SnackbarHostState()

    LaunchedEffect(key1 = true) {
        viewModel.snackbar.collect { snackbarData ->
            snackbarHost.showSnackbar(snackbarData)
        }
    }

    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 48.dp),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHost)
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        viewModel.onEvent(
                            TaskEvent.OnCreateTask
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Task"
                    )
                }

                TextField(
                    label = {
                        Text(text = "Your task")
                    },
                    value = viewModel.taskState.value.title,
                    onValueChange = { value ->
                        viewModel.onEvent(
                            TaskEvent.OnTitleChange(value)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(items = viewModel.taskState.value.tasks) { task ->
                TaskComponent(
                    task = task,
                    onCompleteChange = {
                        viewModel.onEvent(
                            TaskEvent.OnUpdateTask(
                                task = task.copy(isCompleted = it)
                            )
                        )
                    },
                    onDelete = {
                        viewModel.onEvent(
                            TaskEvent.OnDeleteTask(
                                task = task
                            )
                        )
                    }
                )
            }
        }
    }
}