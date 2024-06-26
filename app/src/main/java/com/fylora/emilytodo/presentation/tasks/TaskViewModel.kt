package com.fylora.emilytodo.presentation.tasks

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylora.emilytodo.domain.model.Task
import com.fylora.emilytodo.domain.repository.TaskRepository
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
): ViewModel() {
    private val _taskState = mutableStateOf(TaskState())
    val taskState = _taskState

    init {
        viewModelScope.launch {
            taskRepository.getTasks().collect { tasks ->
                _taskState.value = taskState.value.copy(tasks = tasks)
            }
        }
    }

    fun onEvent(event: TaskEvent) {
        when (event) {
            TaskEvent.OnCreateTask ->
                taskRepository.insertTask(
                    task = Task(
                        title = _taskState.value.title,
                        timestamp = LocalDateTime.now(),
                        isCompleted = false
                    )
                )
            is TaskEvent.OnDeleteTask ->
                taskRepository.deleteTask(event.task)
            is TaskEvent.OnTitleChange ->
                _taskState.value = taskState.value.copy(title = event.title)
            is TaskEvent.OnUpdateTask ->
                taskRepository.insertTask(event.task)
        }
    }
}