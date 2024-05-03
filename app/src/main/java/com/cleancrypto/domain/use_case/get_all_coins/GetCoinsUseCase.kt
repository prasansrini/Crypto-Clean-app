package com.cleancrypto.domain.use_case.get_all_coins

import com.cleancrypto.common.Resource
import com.cleancrypto.data.remote.dto.toCoin
import com.cleancrypto.domain.model.CoinInfo
import com.cleancrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
	operator fun invoke(): Flow<Resource<List<CoinInfo>>> = flow {
		try {
			emit(Resource.Loading())

			val coins = repository
				.getCoins()
				.map { it.toCoin() }
			emit(Resource.Success(coins))

		} catch (httpException: HttpException) {
			emit(Resource.Error(httpException.localizedMessage ?: "An unexpected error occurred!"))
		} catch (ioException: IOException) {
			emit(Resource.Error("Could not reach server. Check your internet connection."))
		}
	}
}