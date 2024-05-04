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
import androidx.navigation.compose.rememberNavController
import me.mahfuzmunna.bfiles.designsystem.component.BFilesNavigationBar
import me.mahfuzmunna.bfiles.designsystem.component.BFilesNavigationBarItem
import me.mahfuzmunna.bfiles.designsystem.component.BFilesTopAppBar
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme
import me.mahfuzmunna.bfiles.navigation.BFilesNavHost
import me.mahfuzmunna.bfiles.navigation.BFilesScreen
import me.mahfuzmunna.bfiles.navigation.TopLevelDestination
import me.mahfuzmunna.bfiles.designsystem.extension.addGradientToBox

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
            val navController = rememberNavController()

            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = {
                    BFilesNavigationBar {
                        TopLevelDestination.entries.forEach {
                            BFilesNavigationBarItem(
                                selected = it == selectedBottomBarItem,
                                onClick = {
                                    onSelectedBottomBarItem(it)
                                    when (it) {
                                        TopLevelDestination.HOME -> navController.navigate(
                                            BFilesScreen.Overview.routeName
                                        )

                                        TopLevelDestination.FILE_SYSTEM -> navController.navigate(
                                            BFilesScreen.MyFiles.routeName
                                        )

                                        TopLevelDestination.EXTENSIONS -> navController.navigate(
                                            BFilesScreen.Extensions.routeName
                                        )
                                    }
                                },
                                selectedIcon = it.selectedIcon,
                                unselectedIcon = it.unselectedIcon,
                                label = stringResource(id = it.iconTextResId)
                            )
                        }
                    }
                }
            ) { padding ->
                Log.d("BFILES", "$padding is unused")
                Column {
                    BFilesTopAppBar(
                        title = "Overview", colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
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

                    BFilesNavHost(navController)
                }
            }
        }
    }
}


@Preview
@Composable
private fun MainScreenPreview() {
    BFilesTheme {
        BFilesApp(selectedBottomBarItem = TopLevelDestination.HOME, appState = BFilesAppState()) {

        }
    }
}