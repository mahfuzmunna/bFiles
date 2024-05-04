package me.mahfuzmunna.bfiles.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import me.mahfuzmunna.bfiles.feature.extensions.navigation.extensionsScreen
import me.mahfuzmunna.bfiles.feature.filesystem.navigation.myFilesScreen
import me.mahfuzmunna.bfiles.feature.home.navigation.HOME_ROUTE
import me.mahfuzmunna.bfiles.feature.home.navigation.homeScreen
import me.mahfuzmunna.bfiles.ui.BFilesAppState

@Composable
fun BFilesNavHost(
    appState: BFilesAppState,
    modifier: Modifier = Modifier
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = modifier
    ) {
        homeScreen()
        myFilesScreen()
        extensionsScreen()
    }
}