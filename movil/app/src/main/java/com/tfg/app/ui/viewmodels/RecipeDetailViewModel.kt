package com.tfg.app.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.tfg.app.model.dto.Recipe
import com.tfg.app.ui.repositories.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeDetailViewModel : ViewModel() {

    private val repository = RecipeRepository()

    private val _recipe = MutableStateFlow<Recipe?>(null)
    val recipe = _recipe.asStateFlow()

    fun loadRecipe(id: Int) {
        _recipe.value = repository.getRecipeById(id)
    }
}