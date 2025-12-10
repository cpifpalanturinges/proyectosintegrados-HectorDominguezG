package com.tfg.app.ui.recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.tfg.app.ui.usables.BottomNavBar
import com.tfg.app.ui.usables.CustomHeader
import com.tfg.app.ui.usables.RecipeItem
import com.tfg.app.ui.viewmodels.RecipeListViewModel

@Composable
fun RecipeListScreen(navController: NavController) {
    val viewModel: RecipeListViewModel = viewModel()
    val recipes by viewModel.recipes.collectAsState()

    Scaffold(
        topBar = { CustomHeader(title = "Recetas") },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addRecipe") },
                containerColor = Color(0xFF8C3A2B),
                contentColor = Color.White
            ) {
                Text("+", fontSize = 28.sp)
            }
        }
    ) { paddingValues ->

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF3E5C2))
        ) {
            items(recipes) { recipe ->
                RecipeItem(recipe = recipe) {
                    navController.navigate("recipeDetail/${recipe.id}")
                }
            }
        }
    }
}

