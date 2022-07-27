package com.example.quizapp.data.api

import com.example.quizapp.domain.model.BaseResponse
import com.example.quizapp.domain.model.auth.UserLoginRequest
import com.example.quizapp.domain.model.auth.UserRegisterRequest
import com.example.quizapp.domain.model.auth.response.UserLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @Author: Temur
 * @Date: 26/07/2022
 */

interface ApiService {

    @POST("register")
    suspend fun register(@Body userRegisterRequest: UserRegisterRequest): String

    @POST("login")
    suspend fun login(@Body userLoginRequest: UserLoginRequest): BaseResponse<UserLoginResponse>
}