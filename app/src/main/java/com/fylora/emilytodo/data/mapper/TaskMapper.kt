package com.fylora.emilytodo.data.mapper

import com.fylora.emilytodo.data.entity.TaskEntity
import com.fylora.emilytodo.domain.model.Task
import java.time.LocalDateTime
import java.time.ZoneOffset

fun TaskEntity.toTask(): Task = Task(
    title = title,
    timestamp = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC),
    isCompleted = isCompleted,
    id = id
)

fun Task.toTaskEntity(): TaskEntity = TaskEntity(
    title = title,
    timestamp = timestamp.toEpochSecond(ZoneOffset.UTC),
    isCompleted = isCompleted,
    id = id
)