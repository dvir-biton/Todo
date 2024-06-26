package com.fylora.emilytodo.domain.repository

import com.fylora.emilytodo.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTask(task: Task)

    suspend fun deleteTask(task: Task)

    suspend fun getTasks(): Flow<List<Task>>
}