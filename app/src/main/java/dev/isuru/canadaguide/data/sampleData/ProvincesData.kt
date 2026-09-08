package dev.isuru.canadaguide.data.sampleData

import dev.isuru.canadaguide.data.model.Province

/**
 * Static reference data for all Canadian provinces and territories.
 * Health and licensing authority names differ by jurisdiction, which is why
 * task descriptions elsewhere in the app substitute these values in rather
 * than hard-coding a single (e.g. Ontario-only) authority name.
 */
object ProvincesData {

    val all: List<Province> = listOf(
        Province(
            id = "on",
            name = "Ontario",
            abbreviation = "ON"
        ),

        Province(
            id = "ns",
            name = "Nova Scotia",
            abbreviation = "NS"
        )
    )

    fun byId(id: String): Province = all.first { it.id == id }
}
