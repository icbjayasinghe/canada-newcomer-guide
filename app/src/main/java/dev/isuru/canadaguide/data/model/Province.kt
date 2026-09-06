package dev.isuru.canadaguide.data.model

data class Province(
    val id: String = "",
    val name: String = "",
    val abbreviation: String = "",
    val activities: List<ProvinceActivity> = emptyList()
)
