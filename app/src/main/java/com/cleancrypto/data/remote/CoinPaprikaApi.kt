package com.cleancrypto.data.remote

import retrofit2.http.GET


interface CoinPaprikaApi {
	@GET
	fun getAllCoins()
}