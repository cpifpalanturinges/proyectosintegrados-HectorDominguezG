package com.tfg.app.ui.repositories

import com.tfg.app.R
import com.tfg.app.model.dto.Recipe

class RecipeRepository {

    private val recipes = listOf(
        Recipe(
            id = 1,
            title = "Pasta Carbonara",
            description = "Receta clásica",
            ingredients = listOf("Pasta", "Huevo", "Panceta"),
            steps = listOf("Hervir pasta", "Freír panceta", "Mezclar todo"),
            time = "25 min",
            difficulty = "Fácil",
            imageRes = R.drawable.carbonara
        ),
        Recipe(
            id = 2,
            title = "Tortilla Española",
            description = "Tradicional",
            ingredients = listOf("Huevos", "Patatas", "Aceite"),
            steps = listOf("Cortar patatas", "Freír", "Cuajar"),
            time = "30 min",
            difficulty = "Media",
            imageRes = R.drawable.carbonara
        )
    )

    fun getRecipeById(id: Int): Recipe? {
        return recipes.find { it.id == id }
    }
}