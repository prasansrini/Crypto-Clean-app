package com.cleancrypto.presentation.coid_detail

import com.cleancrypto.domain.model.CoinDetail

data class CoinDetailState(val isLoading: Boolean = false, val coin: CoinDetail? = null,
                           val error: String = "")
