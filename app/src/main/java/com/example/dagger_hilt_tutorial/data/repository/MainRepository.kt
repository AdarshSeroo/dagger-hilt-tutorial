package com.example.dagger_hilt_tutorial.data.repository

import com.example.dagger_hilt_tutorial.data.api.APIHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: APIHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}