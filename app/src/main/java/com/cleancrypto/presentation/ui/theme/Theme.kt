package com.cleancrypto.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
	primary = ColorPrimary,
	secondary = Color.White,
	background = Color.Black,
	onBackground = TextWhite,
	tertiary = MediumGray,
	onPrimary = DarkGray
)

@Composable
fun CleanCryptoTheme(
	content: @Composable () -> Unit
) {
	MaterialTheme(
		colorScheme = LightColorScheme,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}