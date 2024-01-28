package me.mahfuzmunna.bfiles

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import me.mahfuzmunna.bfiles.ui.theme.BFilesTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (hasPermissions()) {
            renderComposeView()
        } else {
            renderEnableAccessView()
        }
    }

    private fun renderEnableAccessView() {
        setContent {
            BFilesTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "bFiles", style = MaterialTheme.typography.displayMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Column(
                        Modifier.wrapContentHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            requestPermission()
                        }) {
                            Text(text = "Enable File Access")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Read/Write access to file system is required.",
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

    private fun renderComposeView() {
        setContent {
            BFilesTheme {
                Box {
                    Text(text = "TEST")

                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Environment.isExternalStorageManager()) {
                Toast.makeText(this, "RETURN_ALLOWED", Toast.LENGTH_SHORT).show()
                renderComposeView()
            } else {

                Toast.makeText(this, "RETURN_FALSE", Toast.LENGTH_SHORT).show()
            }
        }


    private fun requestPermission() {
        if (isAndroid11OrAbove()) {
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            try {

                intent.addCategory("android.intent.category.DEFAULT")
                intent.data = Uri.fromParts("package", packageName, "")
                resultLauncher.launch(intent)
            } catch (e: Exception) {
                intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                resultLauncher.launch(intent)
            }
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                STORAGE_PERMISSION_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            STORAGE_PERMISSION_REQUEST_CODE -> if (grantResults.isNotEmpty()) {
                val writeStoragePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED
                if (writeStoragePermission) {
                    renderComposeView()
                } else {
//                    Toast.makeText(this, "Allow File Access", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isAndroid11OrAbove() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R

    private fun hasPermissions(): Boolean {
        return if (isAndroid11OrAbove()) {
            Environment.isExternalStorageManager()
        } else {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) ==
                    PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) ==
                    PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        private const val STORAGE_PERMISSION_REQUEST_CODE = 101
    }
}