package com.fylora.emilytodo.domain.repository

import com.fylora.emilytodo.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun insertTask(task: Task)

    fun deleteTask(id: Int)

    fun getTasks(): Flow<List<Task>>
}