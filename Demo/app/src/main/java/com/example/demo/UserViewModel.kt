package com.example.demo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

// TODO: Data class -------------------------------------------------------------------------------
@Serializable
data class User(
    val id: Int,
    val name: String,
    val gender: String,
    val age: Int,
    val country: String,
    val photo: String
) {
    // calculated field based on original field
    val countryName = when (country) {
        "AU" -> "Australia"
        "CA" -> "Canada"
        "GB" -> "Great Britain"
        "NZ" -> "New Zealand"
        "US" -> "United States"
        else -> "Unknown"
    }
}

// TODO: View model -------------------------------------------------------------------------------

class UserViewModel(app: Application) : AndroidViewModel(app) {
    // TODO: Live data
    val usersLiveData =  MutableLiveData<List<User>>()

    // TODO: Init block
    init {
        // cannot access app level context , only Activity and Fragment can, Solution use Android View Model
        val s = app.resources.openRawResource(R.raw.data).reader().readText()
        usersLiveData.value = Json.decodeFromString(s)
    }

    // TODO: Get user by id
    fun get(id: Int) = usersLiveData.value?.find { u -> u.id == id }

    // TODO: Delete user by id
    fun delete(id: Int) {
        usersLiveData.value = usersLiveData.value?.filterNot { u -> u.id == id }
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