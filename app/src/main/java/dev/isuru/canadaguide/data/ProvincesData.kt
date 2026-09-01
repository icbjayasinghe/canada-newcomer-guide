package dev.isuru.canadaguide.data

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
            abbreviation = "ON",
            healthCardName = "OHIP card",
            healthAuthority = "ServiceOntario",
            licenseAuthority = "ServiceOntario (Ministry of Transportation)"
        ),
        Province(
            id = "bc",
            name = "British Columbia",
            abbreviation = "BC",
            healthCardName = "BC Services Card",
            healthAuthority = "Health Insurance BC",
            licenseAuthority = "ICBC"
        ),
        Province(
            id = "ab",
            name = "Alberta",
            abbreviation = "AB",
            healthCardName = "Alberta Health Care card",
            healthAuthority = "Alberta Health Care Insurance Plan (AHCIP)",
            licenseAuthority = "Alberta Registries"
        ),
        Province(
            id = "qc",
            name = "Quebec",
            abbreviation = "QC",
            healthCardName = "carte d'assurance maladie (RAMQ card)",
            healthAuthority = "Régie de l'assurance maladie du Québec (RAMQ)",
            licenseAuthority = "Société de l'assurance automobile du Québec (SAAQ)"
        ),
        Province(
            id = "mb",
            name = "Manitoba",
            abbreviation = "MB",
            healthCardName = "Manitoba Health card",
            healthAuthority = "Manitoba Health",
            licenseAuthority = "Manitoba Public Insurance (MPI)"
        ),
        Province(
            id = "sk",
            name = "Saskatchewan",
            abbreviation = "SK",
            healthCardName = "Saskatchewan Health Card",
            healthAuthority = "eHealth Saskatchewan",
            licenseAuthority = "SGI (Saskatchewan Government Insurance)"
        ),
        Province(
            id = "ns",
            name = "Nova Scotia",
            abbreviation = "NS",
            healthCardName = "MSI card",
            healthAuthority = "Medical Services Insurance (MSI)",
            licenseAuthority = "Access Nova Scotia"
        ),
        Province(
            id = "nb",
            name = "New Brunswick",
            abbreviation = "NB",
            healthCardName = "Medicare card",
            healthAuthority = "New Brunswick Medicare",
            licenseAuthority = "Service New Brunswick"
        ),
        Province(
            id = "nl",
            name = "Newfoundland and Labrador",
            abbreviation = "NL",
            healthCardName = "MCP card",
            healthAuthority = "Medical Care Plan (MCP)",
            licenseAuthority = "Motor Registration Division"
        ),
        Province(
            id = "pe",
            name = "Prince Edward Island",
            abbreviation = "PE",
            healthCardName = "Health PEI card",
            healthAuthority = "Health PEI",
            licenseAuthority = "Access PEI"
        ),
        Province(
            id = "yt",
            name = "Yukon",
            abbreviation = "YT",
            healthCardName = "Yukon Health Care Insurance Plan card",
            healthAuthority = "Yukon Health Care Insurance Plan",
            licenseAuthority = "Motor Vehicles Yukon"
        ),
        Province(
            id = "nt",
            name = "Northwest Territories",
            abbreviation = "NT",
            healthCardName = "NWT Health Care Plan card",
            healthAuthority = "NWT Health Care Plan",
            licenseAuthority = "Motor Vehicles Registry (NWT)"
        ),
        Province(
            id = "nu",
            name = "Nunavut",
            abbreviation = "NU",
            healthCardName = "Nunavut Health Care Plan card",
            healthAuthority = "Nunavut Health Care Plan",
            licenseAuthority = "Motor Vehicles Nunavut"
        )
    )

    fun byId(id: String): Province = all.first { it.id == id }
}
