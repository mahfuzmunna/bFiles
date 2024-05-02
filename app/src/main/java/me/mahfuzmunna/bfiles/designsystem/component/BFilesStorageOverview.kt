package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable

@Composable
fun BFilesStorageOverviewContainer(
    storageItems: @Composable ColumnScope.() -> Unit
) {
    Column(content = storageItems)
}

@Composable
fun ColumnScope.BFilesStorageOverviewItem() {

}
