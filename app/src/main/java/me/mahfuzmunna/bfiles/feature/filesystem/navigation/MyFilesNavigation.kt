package me.mahfuzmunna.bfiles.feature.filesystem.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.mahfuzmunna.bfiles.feature.filesystem.MyFilesRoute

const val FILES_PATH_ARG = "pathUri"
const val MY_FILES_ROUTE_BASE = "my_files_route"
const val MY_FILES_ROUTE = "$MY_FILES_ROUTE_BASE?$FILES_PATH_ARG=$FILES_PATH_ARG"
fun NavController.navigateToMyFiles(navOptions: NavOptions, filesPathUri: String? = null) {
    val route =
        if (filesPathUri != null) "$MY_FILES_ROUTE_BASE?$FILES_PATH_ARG=$filesPathUri" else MY_FILES_ROUTE_BASE
    navigate(route, navOptions)
}

fun NavGraphBuilder.myFilesScreen() {
    composable(
        route = MY_FILES_ROUTE,
        arguments = listOf(
            navArgument(FILES_PATH_ARG) {
                defaultValue = null
                nullable = true
                type = NavType.StringType
            }
        )
    ) {
        MyFilesRoute(onItemClick = { /*TODO*/ })
    }
}