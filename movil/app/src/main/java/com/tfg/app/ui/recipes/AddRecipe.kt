package com.tfg.app.ui.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AddRecipeScreen(navController: NavController) {
    Column {
        Text("Añadir receta")
        Button (onClick = { navController.popBackStack() }) {
            Text("Guardar")
        }
    }
}