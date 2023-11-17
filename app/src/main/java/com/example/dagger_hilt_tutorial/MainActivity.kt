package com.example.dagger_hilt_tutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger_hilt_tutorial.di.module.ApiKey
import com.example.dagger_hilt_tutorial.di.module.LibraryKey
import com.example.dagger_hilt_tutorial.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ApiKey
    @Inject
    lateinit var apiKey:String

    @LibraryKey
    @Inject
    lateinit var libraryKey:String

    private val mainViewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.users.observe(this,{
            Log.d("owner","${it.data}")
        })
    }


}