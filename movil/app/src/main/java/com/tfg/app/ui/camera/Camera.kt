package com.tfg.app.ui.camera

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun CameraScreen(navController: NavController, onBack: () -> Unit) {
    Column {
        CustomHeader(title = "Camara", onBack = onBack)
    }
        Text(
            "Aquí irá CameraX en Compose",
            modifier = androidx.compose.ui.Modifier
                .padding(16.dp)
        )
    }

