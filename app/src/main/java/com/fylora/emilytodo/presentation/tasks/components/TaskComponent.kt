package com.fylora.emilytodo.presentation.tasks.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.emilytodo.domain.model.Task

@Composable
fun TaskComponent(
    task: Task,
    onCompleteChange: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .padding(vertical = 12.dp, horizontal = 24.dp)
            .border(
                width = 2.dp,
                color = if (task.isCompleted) Color.Green
                    else Color.DarkGray,
                shape = RoundedCornerShape(12.dp)
            ).clickable {
                onCompleteChange(!task.isCompleted)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(
                    vertical = 20.dp,
                    horizontal = 10.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = onCompleteChange
            )
            Text(
                text = task.title,
                fontSize = 16.sp,
                modifier = Modifier.weight(0.8f),
                textDecoration = if (task.isCompleted) TextDecoration.LineThrough
                    else TextDecoration.None,
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete Task",
                modifier = Modifier.clickable {
                    onDelete()
                }
            )
        }
    }
}