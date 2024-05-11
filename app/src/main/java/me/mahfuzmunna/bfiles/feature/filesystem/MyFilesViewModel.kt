package me.mahfuzmunna.bfiles.feature.filesystem

import android.os.Environment
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import java.io.File
import kotlin.io.path.Path
import kotlin.io.path.pathString

class MyFilesViewModel : ViewModel() {
    val currentPath = mutableStateOf(Environment.getExternalStorageDirectory().path)
    val listOfFiles = mutableStateListOf<File>()

    init {
        File(currentPath.value).listFiles()?.forEach {
            listOfFiles.add(it)
        }
    }
    // FileEvent occurred -> reload item

//    val watchChannel = currentDirectory.asWatchChannel()





    fun onNavigateToParentPath() {
        if(currentPath.value.length <= Environment.getExternalStorageDirectory().path.length) {
            // already at parent dir
        } else {
            currentPath.value = currentPath.value.dropLastWhile { it == '/' }
        }
    }

    fun onItemCLicked(file: File) {
        if (file.isDirectory) {
            //open directory
            currentPath.value = Path(currentPath.value, file.name).pathString
        }
    }
}

