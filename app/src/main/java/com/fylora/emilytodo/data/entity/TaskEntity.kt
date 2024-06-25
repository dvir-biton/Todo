package com.fylora.emilytodo.data.entity

import androidx.room.Entity

@Entity(tableName = "tasks")
data class TaskEntity(
    val title : String,
    val timestamp: Long,
    val isCompleted: Boolean,
    val id: Int
)
