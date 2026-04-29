package com.jaros.saarekeel.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF58D5FF),
    secondary = Color(0xFF95A4FF),
    tertiary = Color(0xFFFF8CCF),
    background = Color(0xFF0B0D12),
    surface = Color(0xFF121722),
    surfaceVariant = Color(0xFF1B2230),
    onPrimary = Color(0xFF061017),
    onSecondary = Color(0xFF0D1020),
    onTertiary = Color(0xFF240915),
    onBackground = Color(0xFFE8EDF7),
    onSurface = Color(0xFFE8EDF7),
    onSurfaceVariant = Color(0xFFB6C0D2)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun SaarekeelTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
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