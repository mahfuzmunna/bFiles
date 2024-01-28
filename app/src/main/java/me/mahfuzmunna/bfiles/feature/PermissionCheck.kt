package me.mahfuzmunna.bfiles.feature

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.mahfuzmunna.bfiles.R

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun PermissionCheck(modifier: Modifier = Modifier, context: Context) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = context.getString(R.string.app_name),
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.padding(12.dp),
            onClick = {
                // check permission
                if (!Environment.isExternalStorageManager()) {
                    Toast.makeText(context, "StorageMananger not Selected!!", Toast.LENGTH_SHORT)
                        .show()
                    val uri = Uri.fromParts("package", context.packageName, null)
                    val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION,uri)
                    Toast.makeText(context, context.packageName, Toast.LENGTH_SHORT).show()
                    /*
                    App crashes on passing intent.data = uri (only on Samsung)
                    or device where all file access is handled as a list with toggle switch
                    */
//                          intent.data = uri
                    context.startActivity(intent)
                } else Toast.makeText(context, "StorageMananger Selected!!", Toast.LENGTH_SHORT)
                    .show()
            },
        ) {
            Text(
                text = "Grant File Access"
            )

        }

    }
}