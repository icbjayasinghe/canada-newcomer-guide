package dev.isuru.canadaguide.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.isuru.canadaguide.data.model.CountryDocument
import dev.isuru.canadaguide.data.repository.CountryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProvinceViewModel: ViewModel() {
    private val repository = CountryRepository()

    private val _countryDocument = MutableStateFlow<CountryDocument?>(null)
    val countryDocument: StateFlow<CountryDocument?> = _countryDocument.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()


    fun loadCountry() {

        viewModelScope.launch {

            _loading.value = true
            _error.value = null

            try {
                _countryDocument.value = repository.getCountry()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }

    }


}