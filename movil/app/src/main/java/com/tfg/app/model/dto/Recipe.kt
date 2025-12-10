package com.tfg.app.model.dto

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val steps: List<String>,
    val time: String,
    val difficulty: String,
    val imageRes: Int
)