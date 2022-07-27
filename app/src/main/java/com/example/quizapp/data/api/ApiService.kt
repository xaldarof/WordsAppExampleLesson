package com.example.quizapp.data.api

import com.example.quizapp.domain.model.UserRegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author: Temur
 * @Date: 26/07/2022
 */

interface ApiService {

    @POST("/register")
    suspend fun register(@Body userRegisterRequest: UserRegisterRequest):String
}