package dev.isuru.canadaguide.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.isuru.canadaguide.data.ActivitiesData
import dev.isuru.canadaguide.data.ProvincesData
import dev.isuru.canadaguide.ui.screens.ActivitiesScreen
import dev.isuru.canadaguide.ui.screens.ProvinceSelectionScreen
import dev.isuru.canadaguide.ui.screens.TaskListScreen

private object Routes {
    const val PROVINCES = "provinces"
    const val ACTIVITIES = "activities/{provinceId}"
    const val TASKS = "tasks/{provinceId}/{activityId}"

    fun activities(provinceId: String) = "activities/$provinceId"
    fun tasks(provinceId: String, activityId: String) = "tasks/$provinceId/$activityId"
}

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Routes.PROVINCES) {

        composable(Routes.PROVINCES) {
            ProvinceSelectionScreen(
                onProvinceSelected = { province ->
                    navController.navigate(Routes.activities(province.id))
                }
            )
        }

        composable(Routes.ACTIVITIES) { backStackEntry ->
            val provinceId = backStackEntry.arguments?.getString("provinceId") ?: return@composable
            val province = ProvincesData.byId(provinceId)

            ActivitiesScreen(
                province = province,
                onActivityClick = { activity ->
                    navController.navigate(Routes.tasks(province.id, activity.id))
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.TASKS) { backStackEntry ->
            val provinceId = backStackEntry.arguments?.getString("provinceId") ?: return@composable
            val activityId = backStackEntry.arguments?.getString("activityId") ?: return@composable
            val province = ProvincesData.byId(provinceId)
            val activity = ActivitiesData.byId(activityId)

            TaskListScreen(
                province = province,
                activity = activity,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
