package com.example.quizapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Temur
 * @Date: 26/07/2022
 */

class ApiClient {

    private var instance: Retrofit? = null


    fun getInstance(): Retrofit? {
        return if (instance == null) {
            Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        } else {
            instance
        }
    }
}