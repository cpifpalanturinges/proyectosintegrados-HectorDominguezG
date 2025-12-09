package com.tfg.app.ui.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController) {
    val items = (1..30).map { "Elemento $it" }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista") }) }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
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
}
