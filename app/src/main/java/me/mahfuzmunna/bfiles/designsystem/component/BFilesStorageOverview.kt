package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToDrive
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme

@Composable
fun BFilesStorageOverviewContainer(
    storageItems: @Composable ColumnScope.() -> Unit
) {
    Column(
        content = storageItems,
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceAround
    )
}

@Composable
fun BFilesStorageOverviewItem(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onTrailingClick: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(text = title)

        },
        modifier = modifier,
        leadingContent = {
            Icon(imageVector = leadingIcon, contentDescription = "leadingIcon")
        },
        supportingContent = {
            Text(text = subtitle)
        },
        trailingContent = {
            IconButton(onClick = { onTrailingClick() }) {
                Icon(imageVector = trailingIcon, contentDescription = "trailingIcon")
            }
        },
        shadowElevation = 4.dp,
    )
}


@Preview
@Composable
private fun BFilesStorageOverviewContentPreview() {
    BFilesTheme {
        BFilesStorageOverviewContainer {
            BFilesStorageOverviewItem(
                title = "Internal Storage",
                subtitle = "27 GB / 128 GB",
                leadingIcon = Icons.Filled.Folder,
                trailingIcon = Icons.Filled.Diamond
            ) {}
            BFilesStorageOverviewItem(
                title = "External Storage",
                subtitle = "2.5 GB / 32 GB",
                leadingIcon = Icons.Filled.Folder,
                trailingIcon = Icons.Outlined.Diamond
            ) {}
            BFilesStorageOverviewItem(
                title = "Google Drive",
                subtitle = "1.2 GB / 15 GB",
                leadingIcon = Icons.Filled.AddToDrive,
                trailingIcon = Icons.Outlined.Diamond
            ) {}
        }
    }
}