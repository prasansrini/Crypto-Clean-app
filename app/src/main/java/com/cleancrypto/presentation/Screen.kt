package com.cleancrypto.presentation

import com.cleancrypto.common.Constants.NAV_KEY_COIN_DETAIL_SCREEN
import com.cleancrypto.common.Constants.NAV_KEY_COIN_LIST_SCREEN

sealed class Screen(
	val route: String
) {
	data object CoinListScreen : Screen(NAV_KEY_COIN_LIST_SCREEN)
	data object CoinDetailScreen : Screen(NAV_KEY_COIN_DETAIL_SCREEN)
}