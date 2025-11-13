package org.example.app.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.DarkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Primary = Color(0xFF3B82F6)
private val Secondary = Color(0xFF64748B)
private val Tertiary = Color(0xFF06B6D4)
private val Background = Color(0xFF0B0F14)
private val Surface = Color(0xFF111827)
private val Error = Color(0xFFF87171)

private val DarkColors: ColorScheme = DarkColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    onSecondary = Color.White,
    tertiary = Tertiary,
    onTertiary = Color.Black,
    background = Background,
    onBackground = Color(0xFFE5E7EB),
    surface = Surface,
    onSurface = Color(0xFFE5E7EB),
    error = Error,
    onError = Color.Black
)

/**
 * PUBLIC_INTERFACE
 * SmartHomeTheme
 * Dark Material3 theme tuned for TV: deep surfaces with #3b82f6 and #06b6d4 accents.
 */
@Composable
fun SmartHomeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = Typography(),
        content = content
    )
}
