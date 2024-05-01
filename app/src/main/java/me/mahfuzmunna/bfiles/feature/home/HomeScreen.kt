package me.mahfuzmunna.bfiles.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import me.mahfuzmunna.bfiles.designsystem.component.BFilesTopAppBar
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme
import me.mahfuzmunna.bfiles.ui.extension.addGradientToBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .addGradientToBox(MaterialTheme.colorScheme)
            .fillMaxSize()
    ) {
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
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    BFilesTheme {
        HomeScreen()
    }
}