package com.tfg.app.ui.forum

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tfg.app.model.dto.ForumPost
import com.tfg.app.ui.usables.BottomNavBar
import com.tfg.app.ui.usables.CustomHeader

@Composable
fun ForumScreen(navController: NavController) {

    val posts = remember {
        listOf(
            ForumPost("Ana", "¿Alguien sabe cómo hacer masa madre?"),
            ForumPost("Luis", "Recomiendo usar miel en la tarta de manzana"),
            ForumPost("María", "Tips para conservar galletas crujientes")
        )
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xF5E6C4))
    ) {

        CustomHeader(
            title = "Foro",
            canNavigateBack = false
        )

        LazyColumn (
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(posts) { post ->
                Card (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* abrir detalle post si quieres */ },
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF5E0))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(post.author, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(post.content, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }

        BottomNavBar(navController)
    }
}