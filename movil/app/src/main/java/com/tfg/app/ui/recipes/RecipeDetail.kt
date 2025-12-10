package com.tfg.app.ui.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavController
import com.tfg.app.ui.usables.RecipeDetailContent
import com.tfg.app.ui.viewmodels.RecipeDetailViewModel

@Composable
fun RecipeDetailScreen(
    recipeId: Int,
    navController: NavController
) {
    val viewModel = viewModel <RecipeDetailViewModel>()
    val recipe by viewModel.recipe.collectAsState()

    // Cargar receta solo la primera vez
    LaunchedEffect (recipeId) {
        viewModel.loadRecipe(recipeId)
    }

    // Si aún no se ha cargado, muestra un loading
    if (recipe == null) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    // ⬇️ Y aquí llamas a tu diseño de detalle
    RecipeDetailContent (recipe!!, navController)
}