package com.tfg.app.ui.menu

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun HomeScreen(navController: NavController) {

    Column {
        CustomHeader(title = "Inicio")

        Text("Contenido de Inicio")
    }
        Column(
            modifier = Modifier
                .padding()
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { navController.navigate("list") }) {
                Text("Lista (RecyclerView en Compose)")
            }

            Spacer(Modifier.height(16.dp))

            Button(onClick = { navController.navigate("camera") }) {
                Text("Abrir Cámara")
            }

            Spacer(Modifier.height(16.dp))

            Button(onClick = { navController.navigate("gallery") }) {
                Text("Abrir Galería")
            }
        }
    }
