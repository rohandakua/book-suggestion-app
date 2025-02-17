package com.example.bookssuggestionapp

import Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.bookssuggestionapp.data.Data
import com.example.bookssuggestionapp.data.bookItem
import com.example.bookssuggestionapp.ui.theme.BooksSuggestionAppTheme
import com.example.bookssuggestionapp.ui_screens.initialList
import com.example.bookssuggestionapp.viewModels.ItemViewModel
import com.example.bookssuggestionapp.viewModels.SecondViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            initialList(firstViewModel = ItemViewModel(), secondViewModel = SecondViewModel(ItemViewModel()))


        }
    }
}

interface ApiService {
    @GET("public/books")
    suspend fun getItems(): bookItem
}

object RetrofitClient{
    private const val BASE_URL = "https://api.freeapi.app/api/v1/"
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val apiService : ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}

@Preview
@Composable
private fun toShowCoil() {
    Box(modifier = Modifier.fillMaxSize()){
        AsyncImage(model = "http://books.google.com/books/content?id=VWyYDwAAQBAJ",
            contentDescription = null,
            error = painterResource(id = R.drawable.paper))
    }
    
}

