package me.mahfuzmunna.bfiles.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import me.mahfuzmunna.bfiles.feature.extensions.navigation.EXTENSIONS_ROUTE
import me.mahfuzmunna.bfiles.feature.extensions.navigation.navigateToExtensions
import me.mahfuzmunna.bfiles.feature.filesystem.navigation.MY_FILES_ROUTE
import me.mahfuzmunna.bfiles.feature.filesystem.navigation.navigateToMyFiles
import me.mahfuzmunna.bfiles.feature.home.navigation.HOME_ROUTE
import me.mahfuzmunna.bfiles.feature.home.navigation.navigateToHome
import me.mahfuzmunna.bfiles.navigation.TopLevelDestination

@Composable
fun rememberBFilesAppState(
    navController: NavHostController = rememberNavController()
): BFilesAppState {
    return remember(
        navController
    ) {
        BFilesAppState(navController)
    }
}

class BFilesAppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            HOME_ROUTE -> TopLevelDestination.HOME
            MY_FILES_ROUTE -> TopLevelDestination.MY_FILES
            EXTENSIONS_ROUTE -> TopLevelDestination.EXTENSIONS
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun bFilesNavigateToTopLevelDestinations(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true

        }
        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToHome(topLevelNavOptions)
            TopLevelDestination.MY_FILES -> navController.navigateToMyFiles(topLevelNavOptions)
            TopLevelDestination.EXTENSIONS -> navController.navigateToExtensions(topLevelNavOptions)
        }
    }
}
