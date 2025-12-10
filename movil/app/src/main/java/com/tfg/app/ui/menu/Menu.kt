package com.tfg.app.ui.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.ui.usables.BottomNavBar
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun HomeScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        // ---------- TU HEADER PERSONALIZADO ----------
        CustomHeader(
            title = "Inicio",
            canNavigateBack = false
        )

        // ---------- CONTENIDO PRINCIPAL ----------
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            // BOTÓN: Añadir receta
            Button(
                onClick = { navController.navigate("addrecipe") },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Añadir receta")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN: Ver recetas
            Button(
                onClick = { navController.navigate("recipes") },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.List, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Ver recetas")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN: Foro
            Button(
                onClick = { navController.navigate("forum") },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.Email, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Foro de cocina")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN: Despensa
            Button(
                onClick = { navController.navigate("pantry") },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Mi despensa")
            }
        }

        // ---------- BOTTOM NAV ----------
        BottomNavBar(navController)
    }
}