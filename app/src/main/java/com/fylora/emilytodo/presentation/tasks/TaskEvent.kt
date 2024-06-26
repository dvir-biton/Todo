package com.fylora.emilytodo.presentation.tasks

import com.fylora.emilytodo.domain.model.Task

sealed interface TaskEvent {
    data object OnCreateTask: TaskEvent
    data class OnDeleteTask(val task: Task): TaskEvent
    data class OnUpdateTask(val task: Task): TaskEvent
    data class OnTitleChange(val title: String): TaskEvent
}