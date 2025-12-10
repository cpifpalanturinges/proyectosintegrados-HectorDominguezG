package com.tfg.app.ui.pantry

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.model.dto.PantryItem
import com.tfg.app.ui.usables.BottomNavBar
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun PantryScreen(navController: NavController) {

    // Ejemplo de datos, en una app real vendrían de ViewModel/Repository
    val pantryItems = remember {
        listOf(
            PantryItem("Harina", "1 kg"),
            PantryItem("Azúcar", "500 g"),
            PantryItem("Huevos", "12 unidades"),
            PantryItem("Aceite de oliva", "1 L"),
            PantryItem("Leche", "1 L")
        )
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5E6C4)) // fondo estilo página antigua
    ) {

        // ---------- HEADER ----------
        CustomHeader(
            title = "Mi Despensa",
            canNavigateBack = false
        )

        // ---------- LISTA DE DESPENSA ----------
        LazyColumn (
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(pantryItems) { item ->
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* abrir detalle si quieres */ },
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF5E0) // un poquito más claro para destacar sobre fondo
                    )
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = item.quantity, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        // ---------- BOTTOM NAV ----------
        BottomNavBar(navController)
    }
}