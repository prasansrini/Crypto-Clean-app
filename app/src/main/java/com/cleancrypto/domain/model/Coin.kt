package com.cleancrypto.domain.model

data class CoinInfo(
	val id: String,
	val isActive: Boolean,
	val name: String,
	val rank: Int,
	val symbol: String
)
