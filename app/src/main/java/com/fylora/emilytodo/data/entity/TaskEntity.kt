package com.fylora.emilytodo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    val title : String,
    val timestamp: Long,
    val isCompleted: Boolean,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)
