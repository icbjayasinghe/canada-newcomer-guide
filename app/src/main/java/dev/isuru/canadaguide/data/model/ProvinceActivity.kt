package dev.isuru.canadaguide.data.model

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
data class ProvinceActivity(
    val id: String = "",
    val title: String = "",
    val summary: String = "",
    val icon: String = "",
    val tasks: List<Task> = emptyList()
)
