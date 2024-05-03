package com.cleancrypto.domain.use_case.get_coin

import com.cleancrypto.common.Resource
import com.cleancrypto.data.remote.dto.toCoinDetail
import com.cleancrypto.domain.model.CoinDetail
import com.cleancrypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleCoinUseCase @Inject constructor(private val repository: CoinRepository) {
	operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
		try {
			emit(Resource.Loading())

			val coinDetail = repository
				.getCoinById(coinId)
				.toCoinDetail()
			emit(Resource.Success(coinDetail))
		} catch (httpException: HttpException) {
			emit(Resource.Error(httpException.localizedMessage ?: "An unexpected error occurred!"))
		} catch (ioException: IOException) {
			emit(Resource.Error("Could not reach server. Check your internet connection."))
		}
	}
}