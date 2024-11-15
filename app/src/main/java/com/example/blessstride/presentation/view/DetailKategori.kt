package com.example.blessstride.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.blessstride.presentation.component.TopBarUI
import com.example.blessstride.presentation.viewModel.KategoriVM

@Composable
fun DetailKategori(navController: NavController, id: Int) {
    val kategoriVM = KategoriVM()
    val kategoriList = kategoriVM.kategori.collectAsState().value
    val kategori = kategoriList.find { it.id == id }

    Scaffold (
        topBar = {
            TopBarUI("Detail Kategori", true, navController = navController)
        }
    ) { paddingValues ->
        if (kategori != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    ) {
                        AsyncImage(
                            model = kategori.gambar,
                            contentDescription = kategori.nama,
                            modifier = Modifier
                                .fillMaxSize()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = kategori.nama,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "${kategori.cashBack}% Cash Back ${kategori.deals} Deals",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailKategori() {
    val navController = rememberNavController()
    val kategoriVM = KategoriVM()
    val kategoriList = kategoriVM.kategori.collectAsState().value

    if (kategoriList.isNotEmpty()){
        DetailKategori(navController, kategoriList[0].id)
    }
}