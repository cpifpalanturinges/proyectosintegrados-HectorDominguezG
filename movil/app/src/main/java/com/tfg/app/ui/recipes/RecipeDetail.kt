package com.tfg.app.ui.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun RecipeDetailScreen(navController: NavController, id: Long) {
    Column {
        Text("Detalle de receta ID: $id")
    }
}