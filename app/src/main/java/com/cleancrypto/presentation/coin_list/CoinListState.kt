package com.cleancrypto.presentation.coin_list

import com.cleancrypto.domain.model.CoinInfo

data class CoinListState(val isLoading: Boolean = false, val coins: List<CoinInfo> = emptyList(),
                         val error: String = "")
