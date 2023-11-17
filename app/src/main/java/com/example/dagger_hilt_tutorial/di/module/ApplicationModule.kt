package com.example.dagger_hilt_tutorial.di.module

import android.os.Build
import com.example.dagger_hilt_tutorial.BuildConfig
import com.example.dagger_hilt_tutorial.data.api.APIHelper
import com.example.dagger_hilt_tutorial.data.api.APIHelperImpl
import com.example.dagger_hilt_tutorial.data.api.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class  )
class ApplicationModule {

    @ApiKey
    @Provides
    @Singleton
    fun provideApiKey():String = "My ApiKey"

    @LibraryKey
    @Provides
    @Singleton
    fun provideLibraryKey():String = "My Library Key"

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(APIService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: APIHelperImpl): APIHelper = apiHelper
}