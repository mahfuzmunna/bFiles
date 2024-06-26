package me.mahfuzmunna.bfiles.feature.home

import android.os.Build
import android.os.Environment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Folder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.mahfuzmunna.bfiles.designsystem.component.BFilesStorageItem
import me.mahfuzmunna.bfiles.designsystem.component.BFilesStorageOverviewContainer
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme

@Composable
fun HomeRoute() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
//            .addGradientToBox(MaterialTheme.colorScheme)
            .fillMaxSize()
    ) {
        Column {
            BFilesStorageOverviewContainer() {
                val storage = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    Environment.getStorageDirectory()
                } else {
                    null
                }
                val externalStorage = Environment.getExternalStorageDirectory()
                if (externalStorage != null) {
                    BFilesStorageItem(
                        title = "Internal Storage",
                        subtitle = "${
                            String.format(
                                "%.2f",
                                externalStorage.freeSpace.toDouble() / (1024 * 1024 * 1024)
                            )
                        } GB out of ${
                            String.format(
                                "%.2f",
                                externalStorage.totalSpace.toDouble() / (1024 * 1024 * 1024)
                            )
                        } GB",
                        leadingIcon = Icons.Filled.Folder,
                        trailingIcon = Icons.Filled.Diamond
                    ) {

                    }
                }

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
