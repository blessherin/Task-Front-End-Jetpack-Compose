package com.example.blessstride.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blessstride.presentation.model.Kategori
import com.example.blessstride.presentation.model.User
import com.example.blessstride.presentation.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserVM: ViewModel() {
    val userRepository = UserRepository()
    private val _user = MutableStateFlow<List<User>>(emptyList())
    val user: StateFlow<List<User>> get() = _user

    init {
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            _user.value = userRepository.getUser()
        }
    }
}