package com.techmeskills.an16.homework04.di

import com.techmeskills.an16.homework04.network.BASE_URL
import com.techmeskills.an16.homework04.network.RealEstateService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
object NetworkModule {
    @Provides
    @Singleton
    fun getRetrofit(converterFactory: GsonConverterFactory): RealEstateService =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
            .create(RealEstateService::class.java)

    @Provides
    fun getGsonConverterFactory() = GsonConverterFactory.create()
}