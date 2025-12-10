package com.tfg.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF8C3A2B),      // rojo-marrón
    secondary = Color(0xFF5D4037),    // marrón oscuro
    tertiary = Color(0xFFD7CCC8),     // marrón claro / separadores
    background = Color(0xFF3E2723),   // fondo oscuro opcional
    surface = Color(0xFF4E342E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color(0xFFFFF3E0),
    onSurface = Color(0xFFFFF3E0)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF8C3A2B),
    secondary = Color(0xFF5D4037),
    tertiary = Color(0xFFD7CCC8),
    background = Color(0xFFF3E5C2),  // fondo estilo papel antiguo
    surface = Color(0xFFFFF4D4),     // tarjetas estilo hoja
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color(0xFF4E342E),
    onSurface = Color(0xFF4E342E)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}