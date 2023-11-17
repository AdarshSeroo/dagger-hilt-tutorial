package com.example.dagger_hilt_tutorial.data.api

import com.example.dagger_hilt_tutorial.data.model.User
import retrofit2.Response

interface APIHelper {
    suspend fun getUsers(): Response<List<User>>
}