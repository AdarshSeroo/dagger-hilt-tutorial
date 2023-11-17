package com.example.dagger_hilt_tutorial.data.api

import com.example.dagger_hilt_tutorial.data.model.User
import retrofit2.Response
import javax.inject.Inject

class APIHelperImpl@Inject constructor(private val apiService: APIService) : APIHelper {

    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}