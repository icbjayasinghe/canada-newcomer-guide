package dev.isuru.canadaguide.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Wifi
import dev.isuru.canadaguide.data.model.ProvinceActivity

/**
 * The setup activities shown for every province. The list of activities is the
 * same nationwide; what differs by province is the *task content* inside each
 * one (see [TasksData]), since the responsible authority and card names change.
 */
object ActivitiesData {

    val all: List<ProvinceActivity> = listOf(
        ProvinceActivity(
            id = "sin",
            title = "Apply for a SIN",
            summary = "Your Social Insurance Number — required to work and access benefits",
            icon = Icons.Filled.Badge.toString()
        ),
        ProvinceActivity(
            id = "health",
            title = "Get a Health Card",
            summary = "Provincial health coverage so medical visits are covered",
            icon = Icons.Filled.LocalHospital.toString()
        ),
        ProvinceActivity(
            id = "bank",
            title = "Open a Bank Account",
            summary = "Set up chequing, savings, and a newcomer banking package",
            icon = Icons.Filled.AccountBalance.toString()
        ),
        ProvinceActivity(
            id = "license",
            title = "Get a Driver's License",
            summary = "Exchange or apply for a licence to drive in your province",
            icon = Icons.Filled.DirectionsCar.toString()
        ),
        ProvinceActivity(
            id = "housing",
            title = "Find Housing",
            summary = "Search listings, understand leases, and avoid rental scams",
            icon = Icons.Filled.Home.toString()
        ),
        ProvinceActivity(
            id = "phone",
            title = "Get Phone & Internet",
            summary = "Compare carriers and set up a mobile and home internet plan",
            icon = Icons.Filled.Wifi.toString()
        ),
        ProvinceActivity(
            id = "tax",
            title = "Register for Taxes",
            summary = "Set up a CRA My Account and understand your filing obligations",
            icon = Icons.Filled.Receipt.toString()
        ),
        ProvinceActivity(
            id = "doctor",
            title = "Find a Family Doctor",
            summary = "Get on a patient registry and know your options for care",
            icon = Icons.Filled.MedicalServices.toString()
        ),
        ProvinceActivity(
            id = "transit",
            title = "Learn Public Transit",
            summary = "Understand fares, transit apps, and getting around your city",
            icon = Icons.Filled.DirectionsBus.toString()
        ),
        ProvinceActivity(
            id = "school",
            title = "Enroll Kids in School",
            summary = "Register children with your local school board",
            icon = Icons.Filled.School.toString()
        )
    )

    fun byId(id: String): ProvinceActivity = all.first { it.id == id }
}
