package me.mahfuzmunna.bfiles.feature.filesystem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.consumeAsFlow
import me.mahfuzmunna.bfiles.designsystem.component.BFilesFileSystemViewContainer
import java.io.File

@Composable
fun MyFilesRoute(
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
    viewModel: MyFilesViewModel = viewModel<MyFilesViewModel>()
) {
    MyFilesScreen(viewModel)
}

@Composable
fun MyFilesScreen(
    viewModel: MyFilesViewModel,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    Column {
        val filesInPath = viewModel.listOfFiles.toTypedArray().sortedArray()
        BFilesFileSystemViewContainer(
            path = viewModel.currentPath.value.trim().splitToSequence('/')
                .filter { it.isNotEmpty() }.toList(),
            listOfFiles = filesInPath,
            onItemClick = viewModel::onItemCLicked
        )
        val currentDir = File(viewModel.currentPath.value)
        val watchChannel = currentDir.asWatchChannel(scope = coroutineScope).consumeAsFlow()
            .collectAsState(initial = null)

//        if (watchChannel.value != null) {
//            // update files list
//            println("watched : ${watchChannel.value!!.file}")
//            File(viewModel.currentPath.value).listFiles()?.let {
//                viewModel.listOfFiles.clear()
//                viewModel.listOfFiles.addAll(it)
//            }
//        }
        LaunchedEffect(key1 = watchChannel.value) {
            File(viewModel.currentPath.value).listFiles()?.let {
                viewModel.listOfFiles.clear()
                viewModel.listOfFiles.addAll(it)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

    }
}
