package com.cleancrypto.data.remote.dto


import com.cleancrypto.domain.model.CoinInfo
import com.google.gson.annotations.SerializedName

data class CoinInfoDto(
	val id: String,
	@SerializedName("is_active")
	val isActive: Boolean,
	@SerializedName("is_new")
	val isNew: Boolean,
	val name: String,
	val rank: Int,
	val symbol: String,
	val type: String
)

fun CoinInfoDto.toCoin(): CoinInfo {
	return CoinInfo(
		id = id,
		isActive = isActive,
		name = name,
		rank = rank,
		symbol = symbol
	)
}