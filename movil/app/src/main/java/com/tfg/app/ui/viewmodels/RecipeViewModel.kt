package com.tfg.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.tfg.app.ui.repositories.RecipeRepository
import com.tfg.app.model.dto.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeListViewModel : ViewModel() {

    private val repository = RecipeRepository()

    // Lista de recetas observable
    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes = _recipes.asStateFlow()

    init {
        loadRecipes()
    }

    fun loadRecipes() {
        _recipes.value = listOf(
            repository.getRecipeById(1),
            repository.getRecipeById(2)
        ).filterNotNull() // aseguramos que no haya null
    }
}
