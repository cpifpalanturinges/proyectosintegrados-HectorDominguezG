package com.tfg.app.ui.camera

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Cámara") }) }
    ) { padding ->
        Text(
            "Aquí irá CameraX en Compose",
            modifier = androidx.compose.ui.Modifier
                .padding(padding)
                .padding(16.dp)
        )
    }
}
