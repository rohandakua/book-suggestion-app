package com.example.bookssuggestionapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookssuggestionapp.data.DataX
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SecondViewModel (private val firstViewModel: ItemViewModel ): ViewModel(){
    private val _items= MutableStateFlow<List<DataX>>(emptyList<DataX>())
    val items: StateFlow<List<DataX>> = _items
    init{
        fetchItemsBasedOnFirstViewModel ()
    }

    private fun fetchItemsBasedOnFirstViewModel() {
        viewModelScope.launch {
            firstViewModel.item.collect{
                item->
                item?.let {
                    val newListIs = item.data
                    _items.value=newListIs
                }
            }
        }
    }

}