package br.com.brq.samplesdui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.brq.samplesdui.data.SampleSDUIRepository
import com.github.codandotv.craftd.androidcore.data.model.base.SimpleProperties
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SampleSDUIComposeViewModel(private val repository: SampleSDUIRepository) : ViewModel() {
    private val _properties = MutableStateFlow<ImmutableList<SimpleProperties>>(persistentListOf())
    val properties = _properties.stateIn(
        viewModelScope, SharingStarted.Eagerly,
        initialValue = _properties.value
    )

    fun loadProperties() {
        viewModelScope.launch {
            repository.getDynamic().collectLatest { newList ->
                _properties.update {
                    newList.toImmutableList()
                }
            }
        }
    }
}