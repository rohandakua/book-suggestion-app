package com.example.bookssuggestionapp

import android.util.Log
import com.example.bookssuggestionapp.data.Data

class ItemRepository {
    private val apiService1  = RetrofitClient.apiService

    suspend fun getItems() : Data{
        try {
            return apiService1.getItems().data
        }catch (e: Exception){
            Log.e("REQUEST","request aa rhi ha but data le nhi pa rha hu")
        }
        return TODO("Provide the return value")
    }
}