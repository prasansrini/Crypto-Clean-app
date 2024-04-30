package com.cleancrypto.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
	primary = ColorPrimary,
	background = Color.White,
	onBackground = MediumGray,
	onPrimary = DarkGray
)

private val LightColorScheme = lightColorScheme(
	primary = ColorPrimary,
	secondary = Color.White,
	tertiary = MediumGray,
	onPrimary = DarkGray
)

@Composable
fun CleanCryptoTheme(
	darkTheme: Boolean = true,
	content: @Composable () -> Unit
) {
	val colors = if (darkTheme) {
		DarkColorScheme
	} else {
		LightColorScheme
	}

	MaterialTheme(
		colorScheme = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}