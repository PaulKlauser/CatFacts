package com.paulklauser.catfacts.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulklauser.catfacts.CatFactService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val service = CatFactService()

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun fetchCatFact() {
        viewModelScope.launch {
            _uiState.update { it.copy(catFact = service.fetchCatFact()) }
        }
    }

}

data class UiState(
    val catFact: String? = null
)