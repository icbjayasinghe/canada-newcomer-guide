package dev.isuru.canadaguide.data

import dev.isuru.canadaguide.data.model.Province

/**
 * Builds the task checklist for a given activity, tailored to the selected
 * province. SIN and tax registration are federal and stay identical across
 * provinces; health cards, driver's licences, and transit content reference
 * the specific provincial authority.
 */
object TasksData {

    fun tasksFor(provinceOld: Province, activityId: String): List<TaskItemOld> {
        return when (activityId) {
            "sin" -> sinTasks()
            "health" -> healthTasks(provinceOld)
            "bank" -> bankTasks()
            "license" -> licenseTasks(provinceOld)
            "housing" -> housingTasks()
            "phone" -> phoneTasks()
            "tax" -> taxTasks()
            "doctor" -> doctorTasks(provinceOld)
            "transit" -> transitTasks(provinceOld)
            "school" -> schoolTasks()
            else -> emptyList()
        }
    }

    private fun sinTasks() = listOf(
        TaskItemOld(
            id = "sin-1",
            title = "Gather your documents",
            description = "Bring your passport plus your work permit, study permit, or PR card. " +
                "If any document is not in English or French, bring a certified translation."
        ),
        TaskItemOld(
            id = "sin-2",
            title = "Apply through Service Canada",
            description = "Apply online at Canada.ca, by mail, or in person at a Service Canada " +
                "Centre. In-person applications usually issue your SIN the same day."
        ),
        TaskItemOld(
            id = "sin-3",
            title = "Confirm your SIN letter",
            description = "You'll receive a confirmation of SIN letter rather than a physical card. " +
                "Keep this letter somewhere safe — you'll need it for payroll and benefits forms."
        ),
        TaskItemOld(
            id = "sin-4",
            title = "Protect your SIN",
            description = "Only share your SIN with employers, financial institutions, and " +
                "government agencies that are legally required to ask for it."
        )
    )

    private fun healthTasks(provinceOld: Province) = listOf(
        TaskItemOld(
            id = "health-1",
            title = "Check your waiting period",
            description = "Some provinces apply a waiting period (often up to 3 months) before " +
                "coverage starts. Check the  website for ${provinceOld.name}'s current rules, " +
                "and consider private interim health insurance to cover the gap."
        ),
        TaskItemOld(
            id = "health-2",
            title = "Gather proof of identity and status",
            description = "You'll typically need your passport, immigration document (PR card, " +
                "work or study permit), and proof you live in ${provinceOld.name}, such as a lease or utility bill."
        ),
        TaskItemOld(
            id = "health-3",
            title = "Apply for your ",
            description = "Submit your application to , either online, " +
                "by mail, or in person, depending on what your province offers."
        ),
        TaskItemOld(
            id = "health-4",
            title = "Carry your card once it arrives",
                description = "Bring your  to every medical appointment. " +
                "Without it, clinics may charge you directly for visits."
        )
    )

    private fun bankTasks() = listOf(
        TaskItemOld(
            id = "bank-1",
            title = "Compare newcomer banking packages",
            description = "Most major banks offer a fee-free newcomer package for the first year, " +
                "sometimes bookable before you even land in Canada."
        ),
        TaskItemOld(
            id = "bank-2",
            title = "Bring the right documents",
            description = "You'll typically need two pieces of ID (passport plus PR card, work, or " +
                "study permit) and your Canadian address."
        ),
        TaskItemOld(
            id = "bank-3",
            title = "Open chequing and savings accounts",
            description = "A chequing account covers daily spending and bill payments; a savings " +
                "account is worth opening early to start building a Canadian banking history."
        ),
        TaskItemOld(
            id = "bank-4",
            title = "Set up online and mobile banking",
            description = "Register for online banking and e-Transfer so you can pay bills, send " +
                "money, and monitor your account without visiting a branch."
        )
    )

    private fun licenseTasks(provinceOld: Province) = listOf(
        TaskItemOld(
            id = "license-1",
            title = "Check if your home license qualifies",
            description = "Some countries have a licence exchange agreement with , " +
                "letting you swap your foreign licence directly. Check with  to confirm."
        ),
        TaskItemOld(
            id = "license-2",
            title = "Get an International Driving Permit if driving short-term",
            description = "If you plan to drive before your status is sorted out, an International " +
                "Driving Permit from your home country can temporarily supplement your foreign licence."
        ),
        TaskItemOld(
            id = "license-3",
            title = "Book your test with ",
            description = "If no exchange agreement applies, you'll need to pass a written knowledge " +
                "test and, in most cases, a road test."
        ),
        TaskItemOld(
            id = "license-4",
            title = "Study the local rules of the road",
            description = "Speed limits, signage, and right-of-way rules vary by country — review " +
                "your province's official driver's handbook before testing."
        )
    )

    private fun housingTasks() = listOf(
        TaskItemOld(
            id = "housing-1",
            title = "Decide on a short-term base first",
            description = "Consider booking temporary housing (a short-term rental or extended-stay " +
                "hotel) for your first few weeks so you can view apartments in person before signing a lease."
        ),
        TaskItemOld(
            id = "housing-2",
            title = "Search reputable listing sites",
            description = "Use established rental platforms and local classifieds. Be cautious of " +
                "listings priced well below market rate — a common sign of a rental scam."
        ),
        TaskItemOld(
            id = "housing-3",
            title = "Understand what landlords require",
            description = "Many landlords ask for proof of income, a credit check, or references. " +
                "Without Canadian credit history yet, offering a larger deposit or a guarantor can help."
        ),
        TaskItemOld(
            id = "housing-4",
            title = "Review the lease carefully before signing",
            description = "Check the rent amount, what utilities are included, the notice period, " +
                "and your province's rules on rent increases before you commit."
        )
    )

    private fun phoneTasks() = listOf(
        TaskItemOld(
            id = "phone-1",
            title = "Compare prepaid vs. postpaid plans",
            description = "Prepaid SIM plans need no credit check and are easiest to get on arrival; " +
                "postpaid plans are often cheaper long-term but may require a credit check or deposit."
        ),
        TaskItemOld(
            id = "phone-2",
            title = "Check coverage in your area",
            description = "Carrier coverage quality can vary a lot outside major cities — check " +
                "coverage maps for where you'll actually be living."
        ),
        TaskItemOld(
            id = "phone-3",
            title = "Bundle home internet if you can",
            description = "Many providers discount internet when bundled with a mobile plan. Compare " +
                "a few providers, since promotional pricing changes often."
        )
    )

    private fun taxTasks() = listOf(
        TaskItemOld(
            id = "tax-1",
            title = "Determine your residency status",
            description = "The Canada Revenue Agency (CRA) taxes you differently depending on " +
                "whether you're a resident, deemed resident, or non-resident for tax purposes."
        ),
        TaskItemOld(
            id = "tax-2",
            title = "Register for a CRA My Account",
            description = "Create an online CRA account to track benefit payments, file returns, " +
                "and update your address and direct deposit details."
        ),
        TaskItemOld(
            id = "tax-3",
            title = "Apply for benefits you may be eligible for",
            description = "Newcomers with children may qualify for the Canada Child Benefit; " +
                "most residents qualify for the GST/HST credit. Apply as soon as you're eligible."
        ),
        TaskItemOld(
            id = "tax-4",
            title = "Mark your first filing deadline",
            description = "The personal income tax filing deadline is generally April 30 each year " +
                "— note it even if this is your first partial year of residency."
        )
    )

    private fun doctorTasks(provinceOld: Province) = listOf(
        TaskItemOld(
            id = "doctor-1",
            title = "Join your province's patient registry",
            description = "Several provinces run a central registry connecting unattached patients " +
                "with family doctors accepting new patients — check with ."
        ),
        TaskItemOld(
            id = "doctor-2",
            title = "Use walk-in clinics in the meantime",
            description = "While you wait to be matched with a family doctor, walk-in clinics and " +
                "urgent care centres can handle non-emergency needs with your ."
        ),
        TaskItemOld(
            id = "doctor-3",
            title = "Ask your network for recommendations",
            description = "Community groups, settlement agencies, and local newcomer forums are " +
                "often faster than a registry for finding a doctor who's currently accepting patients."
        )
    )

    private fun transitTasks(provinceOld: Province) = listOf(
        TaskItemOld(
            id = "transit-1",
            title = "Get a reloadable transit card",
            description = "Most cities in  use a tap-card system for buses, subways, " +
                "or light rail — pick one up at a station, transit office, or partner retailer."
        ),
        TaskItemOld(
            id = "transit-2",
            title = "Download the local transit app",
            description = "Real-time arrival apps make navigating unfamiliar routes far easier than " +
                "relying on printed schedules."
        ),
        TaskItemOld(
            id = "transit-3",
            title = "Check for newcomer or income-based discounts",
            description = "Some transit systems offer discounted monthly passes based on income — " +
                "worth checking before paying full fare."
        )
    )

    private fun schoolTasks() = listOf(
        TaskItemOld(
            id = "school-1",
            title = "Find your local school board",
            description = "Public school enrollment is based on your home address — search your " +
                "municipality's school board site to find which school your address is zoned for."
        ),
        TaskItemOld(
            id = "school-2",
            title = "Prepare enrollment documents",
            description = "You'll typically need proof of address, your child's birth certificate " +
                "or passport, immigration documents, and previous school records if available."
        ),
        TaskItemOld(
            id = "school-3",
            title = "Ask about settlement and language support",
            description = "Many school boards offer English or French language support programs " +
                "and settlement workers specifically for newcomer families — ask when you register."
        )
    )
}
