package com.tfg.app.ui.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RecipeListScreen(navController: NavController) {
    Column {
        Text("Lista de recetas")

        Button (onClick = { navController.navigate("addRecipe") }) {
            Text("Añadir receta")
        }
    }
}