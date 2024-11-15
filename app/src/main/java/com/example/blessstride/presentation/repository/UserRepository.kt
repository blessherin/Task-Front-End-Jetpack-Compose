package com.example.blessstride.presentation.repository

import com.example.blessstride.R
import com.example.blessstride.presentation.model.User

class UserRepository {
    private val user = listOf(
        User(1, R.drawable.profile, "Blssherin Pangaribuan","blessherinpangaribuan@gmail.com", "Institut Teknolgi Del", "Teknologi Informasi")
    )

    fun getUser() : List<User> {
        return  user
    }
}