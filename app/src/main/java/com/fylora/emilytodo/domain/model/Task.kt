package com.fylora.emilytodo.domain.model

import java.time.LocalDateTime

data class Task(
    val title : String,
    val timestamp: LocalDateTime,
    val isCompleted: Boolean,
    val id: Int = 0
)