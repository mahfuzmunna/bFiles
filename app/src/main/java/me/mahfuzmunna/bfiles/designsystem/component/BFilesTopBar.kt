package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.mahfuzmunna.bfiles.R
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BFilesTopAppBar(
    titleTextResId: Int,
    colors: TopAppBarColors,
    navigationIcon: ImageVector,
    onNavigationClick: () -> Unit = {},
    actionsIcon: ImageVector,
    onActionClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = titleTextResId))
        },
        colors = colors,
        navigationIcon = {
            IconButton(onClick = { onNavigationClick() }) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = stringResource(id = R.string.navigationButton)
                )
            }
        },
        actions = {
            IconButton(onClick = { onActionClick() }) {
                Icon(
                    imageVector = actionsIcon,
                    contentDescription = stringResource(id = R.string.actionButton)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun BFilesTopAppBarPreview() {
    BFilesTheme {
        BFilesTopAppBar(
            titleTextResId = R.string.feature_home_title,
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
            navigationIcon = Icons.Filled.TipsAndUpdates,
            actionsIcon = Icons.Filled.Settings,
            onNavigationClick = {}) {

        }
    }
}