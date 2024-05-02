package me.mahfuzmunna.bfiles

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import me.mahfuzmunna.bfiles.navigation.TopLevelDestination

class MainViewModel : ViewModel() {

    val selectedBottomBarItem = mutableStateOf(TopLevelDestination.HOME)

    fun onSelectedBottomBarItem(destination : TopLevelDestination) {
        selectedBottomBarItem.value = destination
    }
}