package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddToDrive
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.outlined.Diamond
import androidx.compose.material3.Card
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
    title: String = "Storage",
    storageItems: @Composable ColumnScope.() -> Unit
) {
    Column {
        Text(text = title, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
        Card(content = storageItems, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun BFilesStorageItem(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onTrailingClick: () -> Unit = {},
    onCLick: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(text = title)
        },
        modifier = modifier.clickable {
            onCLick()
        },
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
            BFilesStorageItem(
                title = "Internal Storage",
                subtitle = "27 GB / 128 GB",
                leadingIcon = Icons.Filled.Folder,
                trailingIcon = Icons.Filled.Diamond
            ) {}
            BFilesStorageItem(
                title = "External Storage",
                subtitle = "2.5 GB / 32 GB",
                leadingIcon = Icons.Filled.Folder,
                trailingIcon = Icons.Outlined.Diamond
            ) {}
            BFilesStorageItem(
                title = "Google Drive",
                subtitle = "1.2 GB / 15 GB",
                leadingIcon = Icons.Filled.AddToDrive,
                trailingIcon = Icons.Outlined.Diamond
            ) {}
        }
    }
}