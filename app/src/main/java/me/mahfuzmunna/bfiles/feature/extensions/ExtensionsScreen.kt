package me.mahfuzmunna.bfiles.feature.extensions

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import me.mahfuzmunna.bfiles.R
import me.mahfuzmunna.bfiles.designsystem.component.ExtensionsListContainer
import me.mahfuzmunna.bfiles.designsystem.component.ExtensionsListItem

@Composable
fun ExtensionsRoute(modifier: Modifier = Modifier) {
    ExtensionsScreen()
}

@Composable
fun ExtensionsScreen(modifier: Modifier = Modifier) {
    Column {
        ExtensionsListContainer(
            modifier = modifier,
            title = stringResource(id = R.string.feature_extensions_title)
        ) {
            ExtensionsListItem(

            )
        }
    }
}