package com.example.blessstride.presentation.screen

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Explore: Screen("explore")
    object About: Screen("about")

    object DetailKategori : Screen("detailKategori/{id}") {
        fun DetailKategori(id: Int) = "detailKategori/$id"
    }
}