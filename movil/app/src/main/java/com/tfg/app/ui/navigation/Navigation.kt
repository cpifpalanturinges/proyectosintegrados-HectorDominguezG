package com.tfg.app.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tfg.app.ui.menu.HomeScreen
import com.tfg.app.ui.forum.ForumPostScreen
import com.tfg.app.ui.forum.ForumScreen
import com.tfg.app.ui.pantry.PantryScreen
import com.tfg.app.ui.recipes.AddRecipeScreen
import com.tfg.app.ui.recipes.RecipeDetailScreen
import com.tfg.app.ui.recipes.RecipeListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu"   // pantalla principal de la app
    ) {
        composable(route = "menu"){
            HomeScreen(navController)
        }
        // 📌 Lista principal de recetas
        composable("recipes") {
            RecipeListScreen(navController)
        }

        // 📌 Añadir receta
        composable("addRecipe") {
            AddRecipeScreen(navController)
        }

        // 📌 Detalle de receta con argumento ID
        composable(
            route = "recipeDetail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { entry ->
            val id = entry.arguments?.getLong("id") ?: 0L
            RecipeDetailScreen(navController, id)
        }

        // 📌 Despensa
        composable("pantry") {
            PantryScreen(navController)
        }

        // 📌 Foro
        composable("forum") {
            ForumScreen(navController)
        }

        // 📌 Post del foro
        composable(
            route = "forumPost/{postId}",
            arguments = listOf(navArgument("postId") { type = NavType.LongType })
        ) { entry ->
            val postId = entry.arguments?.getLong("postId") ?: 0L
            ForumPostScreen(navController, postId)
        }
    }
}
