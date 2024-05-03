package com.cleancrypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.cleancrypto.presentation.ui.theme.CleanCryptoTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CleanCryptoTheme {
				Surface(
					color = MaterialTheme.colorScheme.background
				) {

				}
			}
		}
	}
}
