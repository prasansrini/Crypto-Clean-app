package com.cleancrypto.domain.repository

import com.cleancrypto.data.remote.dto.CoinDetailDto
import com.cleancrypto.data.remote.dto.CoinInfoDto

interface CoinRepository {

	suspend fun getCoins(): List<CoinInfoDto>

	suspend fun getCoinById(coinId: String): CoinDetailDto
}