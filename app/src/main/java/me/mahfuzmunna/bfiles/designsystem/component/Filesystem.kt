package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileCopy
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.MoreVert
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
import java.io.File

@Composable
fun BFilesFileSystemViewContainer(
    path: List<String> = listOf("Internal Storage"),
    listOfFiles: Array<File>?,
    onItemClick : (File) -> Unit
) {
    Column {
        Text(text = path.joinToString { "$it/" }, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
        Card(modifier = Modifier.padding(8.dp)) {
            if (listOfFiles != null) {
                LazyColumn {
                    items(listOfFiles) {
                        BFilesFileSytemViewItem(
                            title = it.name,
                            subtitle = it.extension,
                            leadingIcon = if (it.isFile) Icons.Filled.FileCopy else Icons.Filled.Folder,
                            trailingIcon = Icons.Filled.MoreVert
                        ) {
                            onItemClick(it)
                        }
                    }
                }
            } else {
                Text(text = "No Storage device instance available")
            }
        }
    }
}

@Composable
fun BFilesFileSytemViewItem(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    onTrailingClick: () -> Unit = {},
    onClick: () -> Unit
) {
    ListItem(
        headlineContent = {
            Text(text = title)
        },
        modifier = modifier.clickable {
            onClick()
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
private fun BFilesFileSytemContentPreview() {
    BFilesTheme {
        BFilesFileSystemViewContainer(listOfFiles = arrayOf(File("/Home"))) {

        }
    }
}