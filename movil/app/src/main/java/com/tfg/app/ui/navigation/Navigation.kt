package com.tfg.app.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.tfg.app.ui.menu.HomeScreen
import com.tfg.app.ui.list.ListScreen
import com.tfg.app.ui.camera.CameraScreen
import com.tfg.app.ui.gallery.GalleryScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("list") { ListScreen(navController) }
        composable("camera") { CameraScreen(navController) }
        composable("gallery") { GalleryScreen(navController) }
    }
}
