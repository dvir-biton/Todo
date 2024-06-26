package com.fylora.emilytodo.data.repository

import com.fylora.emilytodo.data.local.TaskDao
import com.fylora.emilytodo.data.mapper.toTask
import com.fylora.emilytodo.data.mapper.toTaskEntity
import com.fylora.emilytodo.domain.model.Task
import com.fylora.emilytodo.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(
    private val taskDao: TaskDao
): TaskRepository {
    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toTaskEntity())
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task.toTaskEntity())
    }

    override suspend fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks().map { tasks ->
            tasks.map { task ->
                task.toTask()
            }
        }
    }
}