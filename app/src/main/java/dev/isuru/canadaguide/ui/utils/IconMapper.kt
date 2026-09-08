package dev.isuru.canadaguide.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

object IconMapper {
    fun getIcon(iconName: String?): ImageVector {
        return when {
            iconName?.contains("Icons.Filled.Badge") == true -> Icons.Filled.Badge
            iconName?.contains("Icons.Filled.LocalHospital") == true -> Icons.Filled.LocalHospital
            iconName?.contains("Icons.Filled.AccountBalance") == true -> Icons.Filled.AccountBalance
            iconName?.contains("Icons.Filled.DirectionsCar") == true -> Icons.Filled.DirectionsCar
            iconName?.contains("Icons.Filled.Home") == true -> Icons.Filled.Home
            iconName?.contains("Icons.Filled.Wifi") == true -> Icons.Filled.Wifi
            iconName?.contains("Icons.Filled.Receipt") == true -> Icons.Filled.Receipt
            iconName?.contains("Icons.Filled.MedicalServices") == true -> Icons.Filled.MedicalServices
            iconName?.contains("Icons.Filled.DirectionsBus") == true -> Icons.Filled.DirectionsBus
            iconName?.contains("Icons.Filled.School") == true -> Icons.Filled.School
            else -> Icons.Filled.Help
        }
    }
}
