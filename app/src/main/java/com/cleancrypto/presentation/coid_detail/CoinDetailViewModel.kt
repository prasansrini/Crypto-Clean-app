package com.cleancrypto.presentation.coid_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleancrypto.common.Constants.PARAM_COIN_ID
import com.cleancrypto.common.Resource
import com.cleancrypto.domain.use_case.get_coin.GetSingleCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
	private val getSingleCoinUseCase: GetSingleCoinUseCase, savedStateHandle: SavedStateHandle
) : ViewModel() {

	private val _state = mutableStateOf(CoinDetailState())
	val state: State<CoinDetailState> = _state

	init {
		savedStateHandle
			.get<String>(PARAM_COIN_ID)
			?.let { coinId ->
				getCoin(coinId)
			}
	}

	private fun getCoin(
		coinId: String
	) {
		getSingleCoinUseCase(coinId = coinId)
			.onEach { result ->
				when (result) {
					is Resource.Success -> {
						_state.value = CoinDetailState(coin = result.data)
					}

					is Resource.Error -> {
						_state.value = CoinDetailState(
							error = result.message ?: "An error occurred!"
						)
					}

					is Resource.Loading -> {
						_state.value = CoinDetailState(isLoading = true)
					}
				}
			}
			.launchIn(viewModelScope)
	}
}