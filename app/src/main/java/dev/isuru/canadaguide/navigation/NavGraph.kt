package dev.isuru.canadaguide.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.isuru.canadaguide.ui.screens.ActivitiesScreen
import dev.isuru.canadaguide.ui.screens.ProvinceSelectionScreen
import dev.isuru.canadaguide.ui.screens.ProvinceViewModel
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

    val viewModel: ProvinceViewModel = viewModel()
    NavHost(navController = navController, startDestination = Routes.PROVINCES) {
        composable(Routes.PROVINCES) {
            ProvinceSelectionScreen(viewModel,
                onProvinceSelected = { province ->
                    navController.navigate(Routes.activities(province.id))
                }
            )
        }

        composable(Routes.ACTIVITIES) { backStackEntry ->
            val provinceId = backStackEntry.arguments?.getString("provinceId") ?: return@composable
            ActivitiesScreen(
                viewModel = viewModel,
                provinceId = provinceId,
                onActivityClick = { activity ->
                    navController.navigate(Routes.tasks(provinceId, activity.id))
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.TASKS) { backStackEntry ->
            val provinceId = backStackEntry.arguments?.getString("provinceId") ?: return@composable
            val activityId = backStackEntry.arguments?.getString("activityId") ?: return@composable

            val country by viewModel.countryDocument.collectAsState()
            val province = remember(country, provinceId) {
                country?.provinces?.find { it.id == provinceId }
            }
            val activity = remember(province, activityId) {
                province?.activities?.find { it.id == activityId }
            }
//            val activity = ActivitiesData.byId(activityId)

            TaskListScreen(
                activityOld = activity,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
