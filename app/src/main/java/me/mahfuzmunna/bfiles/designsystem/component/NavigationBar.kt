package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun BFilesNavigationBar(modifier: Modifier = Modifier, content: @Composable RowScope.() -> Unit) {
    NavigationBar(
        modifier = modifier,
        content = content
    )
}

@Composable
fun RowScope.BFilesNavigationBarItem(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    label: String? = null
) {
    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        onClick = { onClick() },
        icon = {
            Icon(
                imageVector = if (selected) selectedIcon else unselectedIcon,
                contentDescription = label
            )
        },
        label = {
            if (!label.isNullOrEmpty()) {
                Text(text = label)
            }
        }
    )
}