package com.fylora.emilytodo.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.fylora.emilytodo.data.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Upsert
    fun insertTask(task: TaskEntity)

    @Delete
    fun deleteTask(id: Int)

    @Query("SELECT * FROM tasks")
    fun getTasks(): Flow<List<TaskEntity>>
}
