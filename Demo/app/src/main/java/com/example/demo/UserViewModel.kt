package com.example.demo

import androidx.lifecycle.ViewModel

// TODO: Data class -------------------------------------------------------------------------------

data class User(
    val id: Int,
    val name: String,
    val gender: String,
    val age: Int,
    val country: String,
    val photo: String
)

// TODO: View model -------------------------------------------------------------------------------

class UserViewModel : ViewModel() {
    // TODO: Live data
    val usersLiveData = 0

    // TODO: Init block


    // TODO: Get user by id
    fun get(id: Int): User? = null

    // TODO: Delete user by id
    fun delete(id: Int) {
        
    }
}

/*
"AU" -> "Australia"
"CA" -> "Canada"
"GB" -> "Great Britain"
"NZ" -> "New Zealand"
"US" -> "United States"
else -> "Unknown"
*/