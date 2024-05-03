package com.cleancrypto.data.remote

import com.cleancrypto.data.remote.dto.CoinDetailDto
import com.cleancrypto.data.remote.dto.CoinInfoDto
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinPaprikaApi {
	@GET("/v1/coins")
	suspend fun getAllCoins(): List<CoinInfoDto>

	@GET("/v1/coins/{coinId}")
	suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}