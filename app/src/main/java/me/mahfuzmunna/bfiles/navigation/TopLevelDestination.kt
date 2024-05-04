package me.mahfuzmunna.bfiles.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Extension
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import me.mahfuzmunna.bfiles.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextResId: Int,
    val titleTextResId: Int
) {
    HOME(
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextResId = R.string.feature_home_nav_title,
        titleTextResId = R.string.feature_home_title
    ),
    MY_FILES(
        selectedIcon = Icons.Filled.Folder,
        unselectedIcon = Icons.Outlined.Folder,
        iconTextResId = R.string.feature_filesystem_nav_title,
        titleTextResId = R.string.feature_filesystem_title
    ),
    EXTENSIONS(
        selectedIcon = Icons.Filled.Extension,
        unselectedIcon = Icons.Outlined.Extension,
        iconTextResId = R.string.feature_extensions_nav_title,
        titleTextResId = R.string.feature_extensions_title
    );
}