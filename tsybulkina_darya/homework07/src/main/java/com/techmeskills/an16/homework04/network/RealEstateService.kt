package com.techmeskills.an16.homework04.network

import retrofit2.http.GET

const val  BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

interface RealEstateService {
    @GET("realestate")
    suspend fun getData(): List<Item>
}