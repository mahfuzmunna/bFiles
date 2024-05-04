package me.mahfuzmunna.bfiles.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.mahfuzmunna.bfiles.feature.home.HomeScreen

@Composable
fun BFilesNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BFilesScreen.Overview.routeName) {
        composable(BFilesScreen.Overview.routeName) {
            HomeScreen(navController)
        }
        composable(BFilesScreen.MyFiles.routeName) {
            Text(text = "My Files")
        }
        composable(BFilesScreen.Extensions.routeName) {
            Text(text = "Extensions")
        }
    }
}