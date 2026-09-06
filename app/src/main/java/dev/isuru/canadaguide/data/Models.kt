package dev.isuru.canadaguide.data

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A Canadian province or territory, with the local names of the authorities
 * newcomers will need to deal with (these differ by jurisdiction).
 */
data class ProvinceOld(
    val id: String,
    val name: String,
    val abbreviation: String,
    val healthCardName: String,
    val healthAuthority: String,
    val licenseAuthority: String
)

/**
 * A top-level setup activity a newcomer needs to complete (e.g. "Get a Health Card").
 */
data class ActivityOld(
    val id: String,
    val title: String,
    val summary: String,
    val icon: ImageVector
)

/**
 * A single actionable step within an activity, with a short description.
 */
data class TaskItemOld(
    val id: String,
    val title: String,
    val description: String
)
