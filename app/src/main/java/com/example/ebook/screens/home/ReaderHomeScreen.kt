package com.example.ebook.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ebook.components.ReaderAppBar
import com.example.ebook.model.MBook
import com.example.ebook.navigation.ReaderScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun Home(navController: NavController = NavController(LocalContext.current)) {
    Scaffold(topBar = {
        ReaderAppBar(title = "EReader", navController = navController)

    },
        floatingActionButton = {
            FABContent {
                navController.navigate(ReaderScreens.SearchScreen.name)
            }

        }) {
        //content
        Surface(modifier = Modifier.fillMaxSize()) {
            //home content
            HomeContent(navController)
        }
    }

}

@Composable
fun HomeContent(navController: NavController){
    Column(
        Modifier.padding(2.dp),
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        Row(modifier = Modifier.align(alignment = Alignment.Start)) {
            TitleSection(label = "Your reading \n" + "activity right now...")
        }
    }
}
@Composable
fun TitleSection(modifier: Modifier = Modifier, label:String) {
    Surface(modifier = modifier.padding(start = 5.dp, top = 1.dp)) {
        Column(){
            Text(text = label, fontSize = 19.sp, fontStyle = FontStyle.Normal, textAlign = TextAlign.Left)
        }
    }
}
@Composable
fun ReadingRightNowArea(books: List<MBook>, navController: NavController){

}
@Composable
fun FABContent(onTap: () -> Unit) {
    FloatingActionButton(
        onClick = { onTap() },
        shape = RoundedCornerShape(50.dp),
        containerColor = Color(0xFF92CBDF)
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Book", tint = Color.White)

    }
}
