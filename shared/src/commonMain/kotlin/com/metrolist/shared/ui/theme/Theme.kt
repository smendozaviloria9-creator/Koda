package com.metrolist.shared.ui.theme

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.MotionScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.metrolist.shared.ui.haptics.MetrolistHapticsProvider

private val LightColors =
    lightColorScheme(
        primary = Color(0xFFB45309),
        onPrimary = Color.White,
        secondary = Color(0xFFF59E0B),
        onSecondary = Color.Black,
        background = Color(0xFFFFFBEB),
        onBackground = Color(0xFF1C1917),
        surface = Color.White,
        onSurface = Color(0xFF1C1917),
        error = Color(0xFFB00020),
        onError = Color.White,
    )

private val DarkColors =
    darkColorScheme(
        primary = Color(0xFFF59E0B),
        onPrimary = Color.Black,
        secondary = Color(0xFFFBBF24),
        onSecondary = Color.Black,
        background = Color.Black,
        onBackground = Color(0xFFF5F5F5),
        surface = Color.Black,
        onSurface = Color(0xFFF5F5F5),
        error = Color(0xFFCF6679),
        onError = Color.Black,
    )

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MetrolistTheme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    val motionScheme = remember { MotionScheme.expressive() }
    MaterialExpressiveTheme(
        colorScheme = animateColorScheme(colors, motionScheme),
        motionScheme = motionScheme,
        typography = Typography(),
        content = { MetrolistHapticsProvider(content) },
    )
}
