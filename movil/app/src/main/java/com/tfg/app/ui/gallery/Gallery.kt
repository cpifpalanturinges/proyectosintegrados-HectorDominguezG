package com.tfg.app.ui.gallery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun GalleryScreen(navController: NavController, onBack: () -> Unit) {
    Column {
        CustomHeader(title = "Galeria", onBack = onBack)
    }
        Text(
            "Aquí se mostrará la galería del dispositivo",
            modifier = androidx.compose.ui.Modifier
                .padding(16.dp)
        )
    }
