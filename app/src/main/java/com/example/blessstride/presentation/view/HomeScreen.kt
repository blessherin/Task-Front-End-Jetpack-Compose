package com.example.blessstride.presentation.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.blessstride.R
import com.example.blessstride.presentation.component.BottomNavBarUI
import com.example.blessstride.presentation.component.TopBarUI
import com.example.blessstride.presentation.model.Kategori
import com.example.blessstride.presentation.screen.Screen
import com.example.blessstride.presentation.viewModel.KategoriVM

@Composable
fun HomeScreen(navController: NavController, kategoriVM: KategoriVM = viewModel()) {
    val kategoris = kategoriVM.kategori.collectAsState()
    val context = LocalContext.current

    Scaffold (
        topBar = {
            TopBarUI("Home", false, navController = navController)
        },
        bottomBar = {
            BottomNavBarUI(navController = navController)
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues))
        {
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                item {
                    Text(
                        text = "Recently Viewed Stores",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.size(15.dp))

                }

                item {
                    LazyRow (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(kategoris.value){ kategori ->
                            KategoriCard(kategori = kategori) {
                                navController.navigate(Screen.DetailKategori.DetailKategori(kategori.id)){
                                    popUpTo(Screen.DetailKategori.route) {inclusive = true}
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.size(15.dp))

                }

                item {
                    Text(
                        text = "Increased Cash Back",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.size(15.dp))

                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        kategoris.value.forEach{ kategori ->
                            KategoriCardColumn(kategori = kategori) {
                                navController.navigate(Screen.DetailKategori.DetailKategori(kategori.id)){
                                    popUpTo(Screen.DetailKategori.route) {inclusive = true}
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun KategoriCard(kategori: Kategori, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(modifier = Modifier.height(80.dp)) {
                AsyncImage(
                    model = kategori.gambar,
                    contentDescription = kategori.nama,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = "${kategori.cashBack}% Cash Back",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 6.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 4.dp, start = 6.dp)
                    .background(Color(0xAA7B1FA2), RoundedCornerShape(12.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Just for you",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}

@Composable
fun KategoriCardColumn(kategori: Kategori, onClick: () -> Unit) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = colorResource(R.color.white))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .size(104.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                AsyncImage(
                    model = kategori.gambar,
                    contentDescription = kategori.nama,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column (
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = kategori.nama,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )

                Text(
                    text = "${kategori.cashBack}% Cash Back",
                    fontSize = 14.sp,
                    color = Color(0xAA7B1FA2),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${kategori.deals} DEALS",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xAA7B1FA2), RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Just for you",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController)
}