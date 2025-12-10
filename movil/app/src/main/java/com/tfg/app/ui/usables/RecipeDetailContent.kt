package com.tfg.app.ui.usables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tfg.app.model.dto.Recipe


@Composable
fun RecipeDetailContent(
    recipe: Recipe,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3E5C2)) // Fondo estilo página antigua
            .verticalScroll(rememberScrollState())
    ) {

        // Header
        CustomHeader(
            title = recipe.title,
            canNavigateBack = true,
            onBack = { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Imagen de receta
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(220.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF4D4)), // hoja envejecida
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Image(
                painter = painterResource(id = recipe.imageRes),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Descripción
        Text(
            text = "Descripción",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Text(
            text = recipe.description,
            fontSize = 16.sp,
            color = Color(0xFF4E342E),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Ingredientes
        Text(
            text = "Ingredientes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)) {
            recipe.ingredients.forEach { ingredient ->
                Text(
                    text = "• $ingredient",
                    fontSize = 16.sp,
                    color = Color(0xFF4E342E),
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Preparación
        Text(
            text = "Preparación",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF5D4037),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)) {
            recipe.steps.forEachIndexed { index, step ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF4D4)),
                    elevation = CardDefaults.cardElevation(3.dp)
                ) {
                    Text(
                        text = "${index + 1}. $step",
                        fontSize = 16.sp,
                        color = Color(0xFF4E342E),
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

