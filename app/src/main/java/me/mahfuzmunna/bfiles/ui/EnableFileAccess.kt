package me.mahfuzmunna.bfiles.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.SettingsSuggest
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.mahfuzmunna.bfiles.ui.extension.addGradientToBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnableFileAccessView(
    requestFileAccess: () -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        val colorScheme = MaterialTheme.colorScheme
        Box(
            modifier = Modifier
                .fillMaxSize()
                .addGradientToBox(colorScheme)

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "bFiles",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Filled.BugReport,
                                contentDescription = "report issues"
                            )

                        }
                    }
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Getting things ready",
                        style = MaterialTheme.typography.displaySmall.copy(fontSize = 23.sp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Image(
                        imageVector = Icons.Filled.SettingsSuggest,
                        contentDescription = "setting",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f),
                        contentScale = ContentScale.Fit
                    )
                }
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(onClick = { requestFileAccess() }) {
                        Text(text = "Allow Storage Access")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Storage access is required to perform file operations.",
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Preview(device = Devices.NEXUS_5X, widthDp = 360, heightDp = 640)
@Composable
private fun EnableFileAccessPreview() {
    EnableFileAccessView()
}
