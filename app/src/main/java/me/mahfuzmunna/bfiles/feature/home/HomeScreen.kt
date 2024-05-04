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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.mahfuzmunna.bfiles.designsystem.component.BFilesStorageOverviewContainer
import me.mahfuzmunna.bfiles.designsystem.component.BFilesStorageItem
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme
import me.mahfuzmunna.bfiles.navigation.BFilesScreen

@Composable
fun HomeScreen(navController : NavHostController) {
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
                        subtitle = "${externalStorage.absolutePath} ${externalStorage.freeSpace/(1024*1024*1024)} GB/${externalStorage.totalSpace/(1024*1024*1024)} GB",
                        leadingIcon = Icons.Filled.Folder,
                        trailingIcon = Icons.Filled.Diamond
                    ) {
                        navController.navigate(BFilesScreen.MyFiles.routeName)
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
        HomeScreen(rememberNavController())
    }
}

private fun storageSpaceText(bytes : Long) : Double {
    return bytes.div(1024).toDouble()
}