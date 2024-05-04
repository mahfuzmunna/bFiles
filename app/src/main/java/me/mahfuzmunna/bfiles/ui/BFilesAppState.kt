package me.mahfuzmunna.bfiles.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import me.mahfuzmunna.bfiles.feature.extensions.navigation.navigateToExtensions
import me.mahfuzmunna.bfiles.feature.filesystem.navigation.navigateToMyFiles
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

    val topLevelDestinations : List<TopLevelDestination> = TopLevelDestination.entries

    fun bFilesNavigateToTopLevelDestinations(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
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
