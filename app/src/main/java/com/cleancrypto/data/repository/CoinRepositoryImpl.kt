package com.cleancrypto.data.repository

import com.cleancrypto.data.remote.CoinPaprikaApi
import com.cleancrypto.data.remote.dto.CoinDetailDto
import com.cleancrypto.data.remote.dto.CoinInfoDto
import com.cleancrypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
	override suspend fun getCoins(): List<CoinInfoDto> {
		return api.getAllCoins()
	}

	override suspend fun getCoinById(coinId: String): CoinDetailDto {
		return api.getCoinById(coinId)
	}
}