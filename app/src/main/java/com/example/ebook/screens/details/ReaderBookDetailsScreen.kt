package com.example.ebook.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ebook.components.ReaderAppBar
import com.example.ebook.data.Resource
import com.example.ebook.model.Item
import com.example.ebook.navigation.ReaderScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailsScreen(navController: NavController, bookId: String, viewModel: DetailsViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        ReaderAppBar(
            title = "Book Details",
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            showProfile = false,
            navController = navController
        ){
            navController.navigate(ReaderScreens.SearchScreen.name)
        }
    }) {
        Surface(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            Column(
                modifier = Modifier.padding(top = 12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val bookInfo = produceState<Resource<Item>>(initialValue = Resource.Loading()){
                    value = viewModel.getBookInfo(bookId)
                }.value
                if(bookInfo.data == null) {
                    LinearProgressIndicator()
                }
                else{
                    Text(text = "Book: ${bookInfo.data.volumeInfo.title}")
                }
            }
        }
    }
}