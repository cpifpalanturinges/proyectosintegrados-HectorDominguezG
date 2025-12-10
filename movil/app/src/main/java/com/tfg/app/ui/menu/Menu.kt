package com.tfg.app.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.R
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
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.chefs_mind_logo_design),
                contentDescription = null
            )
        }


        // ---------- BOTTOM NAV ----------
        BottomNavBar(navController)
    }
}