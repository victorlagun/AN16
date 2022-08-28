package com.example.android.marsrealestate.di

import com.example.android.marsrealestate.network.MarsApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModel {
    val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    @Provides
    @Singleton
    fun getRetrofitService(retrofit: Retrofit):MarsApiService{
        return retrofit.create(MarsApiService::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseUrl)
            .build()
    }
}