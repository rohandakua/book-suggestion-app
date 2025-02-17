package com.example.bookssuggestionapp.viewModels

import android.content.ClipData
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookssuggestionapp.ItemRepository
import com.example.bookssuggestionapp.data.Data
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {
    private val repository = ItemRepository()
    private val itemsare = MutableStateFlow<Data?>(null)
    val item : StateFlow<Data?> = itemsare

    init{
        fetchItem()
    }

    private fun fetchItem() {
        viewModelScope.launch {
            try{
                itemsare.value= repository.getItems()
                Log.e("API","calling succesfull")

            }catch (e:Exception){

                Log.e("API","calling UNsuccesfull")

            }
        }
    }
}