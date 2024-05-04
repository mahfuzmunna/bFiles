package me.mahfuzmunna.bfiles.feature.extensions.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.mahfuzmunna.bfiles.feature.extensions.ExtensionsRoute

const val EXTENSIONS_ROUTE_BASE = "extensions_route"
const val EXTENSIONS_ID_ARG = "extensionId"
const val EXTENSIONS_ROUTE = "$EXTENSIONS_ROUTE_BASE?$EXTENSIONS_ID_ARG=$EXTENSIONS_ID_ARG"

fun NavController.navigateToExtensions(
    navOptions: NavOptions?,
    extensionsId: String? = null,
) {
    val route =
        if (extensionsId != null) "$EXTENSIONS_ROUTE_BASE?$EXTENSIONS_ID_ARG=$extensionsId" else EXTENSIONS_ROUTE_BASE
    navigate(route, navOptions)
}

fun NavGraphBuilder.extensionsScreen() {
    composable(
        route = EXTENSIONS_ROUTE,
        arguments = listOf(
            navArgument(EXTENSIONS_ID_ARG) {
                defaultValue = null
                nullable = true
                type = NavType.StringType
            }
        )
    ) {
        ExtensionsRoute()
    }
}