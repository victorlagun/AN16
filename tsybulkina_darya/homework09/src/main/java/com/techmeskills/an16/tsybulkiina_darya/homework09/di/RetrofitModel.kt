package com.techmeskills.an16.tsybulkiina_darya.homework09.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.techmeskills.an16.tsybulkiina_darya.homework09.network.BASE_URL
import com.techmeskills.an16.tsybulkiina_darya.homework09.network.MarsApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModel {

    @Singleton
    @Provides
    fun getRetrofitService(retrofit: Retrofit): MarsApiService {
        return retrofit.create(MarsApiService::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofit(moshi:Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun getMoshi():Moshi{
        return  Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}