package com.jaros.saarekeel.ui.theme

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
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
    primary = Color(0xFF00687A),
    secondary = Color(0xFF5661A8),
    tertiary = Color(0xFF9B4D79),
    background = Color(0xFFF6F8FC),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE3E8F2),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onTertiary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF10141C),
    onSurface = Color(0xFF10141C),
    onSurfaceVariant = Color(0xFF4B5568)
)

@Composable
fun SaarekeelTheme(
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val darkTheme = isSystemInDarkTheme()
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