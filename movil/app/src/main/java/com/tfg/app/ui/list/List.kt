package com.tfg.app.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun ListScreen(navController: NavController, onBack: () -> Unit) {
    val items = (1..30).map { "Elemento $it" }

    Column {
        CustomHeader(title = "List", onBack = onBack)
    }

        LazyColumn(
            modifier = Modifier
                .padding()
                .fillMaxSize()
        ) {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
