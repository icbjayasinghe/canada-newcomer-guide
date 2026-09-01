# Newcomer Guide (Canada)

An Android app (Kotlin + Jetpack Compose, Material 3) that walks newcomers to
Canada through the essentials to set up, tailored to whichever province or
territory they select.

## Flow

1. **Select a province/territory** — all 10 provinces + 3 territories.
2. **Activities menu** — SIN, health card, bank account, driver's licence,
   housing, phone/internet, taxes, family doctor, transit, school enrollment.
3. **Task checklist** — each activity opens a checklist of concrete steps,
   each with a short description. Task descriptions reference the correct
   provincial authority name (e.g. ICBC vs. SAAQ vs. ServiceOntario) since
   that varies by province — SIN and tax registration are federal, so those
   stay identical everywhere.

## Project structure

```
app/src/main/java/dev/isuru/canadaguide/
  data/            Province, Activity, TaskItem models + static content
  navigation/       Navigation Compose graph (3 routes)
  ui/screens/       ProvinceSelectionScreen, ActivitiesScreen, TaskListScreen
  ui/theme/         Custom Material 3 color scheme, type, shapes
```

## Running it

Open the project root in Android Studio (Ladybug or newer) — it will run
Gradle sync automatically using the included `settings.gradle.kts`,
`build.gradle.kts`, and `gradle/wrapper/gradle-wrapper.properties`.

Minimum requirements:
- Android Studio Ladybug (2024.2) or newer
- JDK 17
- minSdk 26 / targetSdk 35 / compileSdk 35

## A note on this build

This project was generated in a sandboxed environment without network access
to Google's Maven repository or an installed Android SDK, so **Gradle sync
was not run here** — unlike a typical scaffold, this hasn't been build-verified.
The code was written carefully (consistent imports, balanced braces, standard
Navigation Compose/Material 3 APIs) but you should run Gradle sync in Android
Studio as your first step and fix anything it flags.

## Extending it

- `TasksData.kt` is the place to add more detail per activity, or add
  province-specific edge cases (e.g. Quebec-specific francophone forms).
- To add a new activity, add an entry to `ActivitiesData.kt` and a matching
  branch in `TasksData.tasksFor()`.
- Task completion state currently resets each time you leave a screen —
  wiring it to `DataStore` for persistence would be a natural next step.
