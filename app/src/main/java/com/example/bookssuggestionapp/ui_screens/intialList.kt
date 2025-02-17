package com.example.bookssuggestionapp.ui_screens

import Item
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookssuggestionapp.viewModels.ItemViewModel
import com.example.bookssuggestionapp.viewModels.SecondViewModel

import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import com.example.bookssuggestionapp.R
import com.example.bookssuggestionapp.data.DataX
import tocallItem


@Composable
fun initialList(modifier: Modifier=Modifier,
                firstViewModel : ItemViewModel = ItemViewModel(),
                secondViewModel: SecondViewModel=SecondViewModel(firstViewModel)
) {
    val items = secondViewModel.items.collectAsState().value
    var selectedItem by remember {
        mutableStateOf<DataX?>(null)
    }
    if(selectedItem==null){
        Box(modifier = modifier.fillMaxSize()) {
            Column {
                Box(
                    modifier = Modifier
                        .height(20.dp) // Set the height of the spacer
                        .fillMaxWidth() // Make it full width or adjust as needed
                        .background(colorResource(id = R.color.backgroundCustom)) // Set the background color
                )
                LazyColumn(contentPadding = PaddingValues(bottom = 4.dp)) {
                    items(items) { item ->
                        tocallItem(whenClicked = {
                            selectedItem = item

                        }, demo = item)
                    }
                }
            }
        }
    }else{
        eachItemClicked(book = selectedItem!!)
    }

}