package com.example.quizapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Temur
 * @Date: 26/07/2022
 */

class ApiClient {

    private var instance: Retrofit? = null

    private val BASE_URL = "https://api.mamadaliyev.uz/user/"

    fun getInstance(): Retrofit? {

        val interceptor = HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();

        return if (instance == null) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        } else {
            instance
        }
    }
}