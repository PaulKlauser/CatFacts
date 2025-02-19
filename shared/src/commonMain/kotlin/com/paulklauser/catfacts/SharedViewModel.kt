package com.paulklauser.catfacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

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