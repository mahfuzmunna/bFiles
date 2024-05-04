package me.mahfuzmunna.bfiles

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import me.mahfuzmunna.bfiles.designsystem.theme.BFilesTheme
import me.mahfuzmunna.bfiles.ui.BFilesApp
import me.mahfuzmunna.bfiles.common.EnableFileAccessView
import me.mahfuzmunna.bfiles.ui.rememberBFilesAppState

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val splashScreen = installSplashScreen()

        if (hasPermission()) {
            renderComposeView()
        } else {
            renderEnableFileAccessView()
        }
    }

    override fun onStart() {
        super.onStart()
        if (hasPermission()) {
            renderComposeView()
        } else {
            renderEnableFileAccessView()
        }
    }


    private fun renderEnableFileAccessView() {
        // Storage permission required
        setContent {
            BFilesTheme {
                EnableFileAccessView {
                    requestPermission()
                }
            }
        }
    }

    private fun isAndroid11OrAbove() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R


    private fun requestPermission() {
        if (isAndroid11OrAbove()) {
            val intent = Intent(
                Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION,
                Uri.fromParts("package", packageName, null)
            )
            startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                STORAGE_PERMISSION_REQ_CODE
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
            STORAGE_PERMISSION_REQ_CODE -> if (grantResults.isNotEmpty()) {
                val writeStoragePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED
                if (writeStoragePermission) {
                    renderComposeView()
                } else {
//                    Toast.makeText(this, "Allow File Access", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun renderComposeView() {
        // App has Storage permission & can go forward
        setContent {
            BFilesTheme {
                val appState = rememberBFilesAppState()
                BFilesApp(
                    selectedBottomBarItem = viewModel.selectedBottomBarItem.value,
                    appState = appState
                ) {
                    viewModel.onSelectedBottomBarItem(it)
                }
            }
        }
    }


    private fun hasPermission(): Boolean {
        return if (isAndroid11OrAbove()) {
            Environment.isExternalStorageManager()
        } else {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        private const val STORAGE_PERMISSION_REQ_CODE = 1001
    }
}