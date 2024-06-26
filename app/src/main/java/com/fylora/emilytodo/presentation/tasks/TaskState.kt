package com.fylora.emilytodo.presentation.tasks

import com.fylora.emilytodo.domain.model.Task

data class TaskState(
    val title: String = "",
    val tasks: List<Task> = emptyList()
)
