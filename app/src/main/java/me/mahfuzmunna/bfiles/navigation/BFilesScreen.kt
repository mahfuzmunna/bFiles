package me.mahfuzmunna.bfiles.navigation

sealed class BFilesScreen(val routeName : String) {
    object Overview : BFilesScreen("overview_screen")
    object MyFiles : BFilesScreen("myfiles_screen")
    object Extensions : BFilesScreen("extensions_screen")
}