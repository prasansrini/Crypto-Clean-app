package com.cleancrypto.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cleancrypto.presentation.coid_detail.components.CoinDetailScreen
import com.cleancrypto.presentation.coin_list.components.CoinListScreen
import com.cleancrypto.presentation.ui.theme.CleanCryptoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CleanCryptoTheme {
				Surface(
					color = MaterialTheme.colorScheme.background
				) {
					val navController = rememberNavController()
					NavHost(
						navController = navController,
						startDestination = Screen.CoinListScreen.route
					) {
						composable(
							route = Screen.CoinListScreen.route
						) {
							CoinListScreen(navController = navController)
						}
						composable(
							route = Screen.CoinDetailScreen.route + "/{coinId}"
						) {
							CoinDetailScreen()
						}
					}
				}
			}
		}
	}
}
