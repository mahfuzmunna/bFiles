package me.mahfuzmunna.bfiles.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.mahfuzmunna.bfiles.designsystem.component.BFilesStorageOverviewContainer
import me.mahfuzmunna.bfiles.designsystem.component.BFilesStorageOverviewItem
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
//            .addGradientToBox(MaterialTheme.colorScheme)
            .fillMaxSize()
    ) {
//        Column {
//            BFilesStorageOverviewContainer {
//                BFilesStorageOverviewItem()
//            }
//        }
    }
}




@Preview
@Composable
private fun HomeScreenPreview() {
    BFilesTheme {
        HomeScreen()
    }
}