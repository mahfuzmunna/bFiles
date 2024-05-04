package me.mahfuzmunna.bfiles.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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
}
