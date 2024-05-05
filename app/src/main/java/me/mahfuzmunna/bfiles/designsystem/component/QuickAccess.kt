package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme

@Composable
fun BFilesQuickAccessContainer(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column {
        Text(text = title, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp))
        Card(content = content)
    }
}

@Composable
fun BFilesQuickAccessItem(modifier: Modifier = Modifier) {
    ListItem(
        headlineContent = {
            Text(text = "headline")
        },
        shadowElevation = 5.dp,
    )
}

@Preview
@Composable
fun BFilesQuickAccessPreview(modifier: Modifier = Modifier) {
    BFilesTheme {
        BFilesQuickAccessContainer(title = "Quick Access") {
            BFilesQuickAccessItem()
            BFilesQuickAccessItem()
            BFilesQuickAccessItem()
        }
    }
}