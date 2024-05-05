package me.mahfuzmunna.bfiles.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import me.mahfuzmunna.bfiles.designsystem.component.BFilesNavigationBar
import me.mahfuzmunna.bfiles.designsystem.component.BFilesNavigationBarItem
import me.mahfuzmunna.bfiles.designsystem.component.BFilesTopAppBar
import me.mahfuzmunna.bfiles.designsystem.extension.addGradientToBox
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme
import me.mahfuzmunna.bfiles.navigation.BFilesNavHost
import me.mahfuzmunna.bfiles.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BFilesApp(
    appState: BFilesAppState,
    selectedBottomBarItem: TopLevelDestination,
    onSelectedBottomBarItem: (TopLevelDestination) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .addGradientToBox(MaterialTheme.colorScheme)
                .fillMaxSize()
        ) {
            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = {
                    BFilesBottomBar(
                        destinations = appState.topLevelDestinations,
                        currentDestination = appState.currentDestination,
                        onNavigateToDestination = appState::bFilesNavigateToTopLevelDestinations
                    )
                }
            ) { padding ->
                Log.d("BFILES", "$padding is unused")
                Column {
                    val destination = appState.currentTopLevelDestination
                    if (destination != null) {
                        BFilesTopAppBar(
                            titleTextResId = destination.titleTextResId,
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color.Transparent
                            ),
                            navigationIcon = Icons.Filled.Search,
                            onNavigationClick = {
                                // open search panel
                            },
                            actionsIcon = Icons.Filled.Settings
                        ) {
                            // open settings modalsheet
                        }
                    }

                    BFilesNavHost(appState)
                }
            }
        }
    }
}

@Composable
fun BFilesBottomBar(
    modifier: Modifier = Modifier,
    destinations: List<TopLevelDestination>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (TopLevelDestination) -> Unit
) {
    BFilesNavigationBar {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            BFilesNavigationBarItem(
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination)
                },
                selectedIcon = destination.selectedIcon,
                unselectedIcon = destination.unselectedIcon,
                label = stringResource(id = destination.iconTextResId)
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        println("destName : ${destination.name}")
        println("hierarchy : ${this.route}")
        it.route?.contains(destination.name, true) ?: false
    } ?: false


@Preview
@Composable
private fun MainScreenPreview() {
    BFilesTheme {
        BFilesApp(
            selectedBottomBarItem = TopLevelDestination.HOME,
            appState = rememberBFilesAppState()
        ) {

        }
    }
}