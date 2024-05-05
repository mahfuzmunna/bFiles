package me.mahfuzmunna.bfiles.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExtensionsListContainer(modifier: Modifier = Modifier, title : String, content : @Composable ColumnScope.() -> Unit) {
    Column {
        Text(text = title)
        Card(content = content)
    }
}

@Composable
fun ExtensionsListItem(modifier: Modifier = Modifier) {

}