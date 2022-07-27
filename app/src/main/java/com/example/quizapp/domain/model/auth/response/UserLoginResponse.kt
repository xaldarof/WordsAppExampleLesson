package com.example.quizapp.domain.model.auth.response

/**
 * @Author: Temur
 * @Date: 27/07/2022
 */

data class UserLoginResponse(
    val user: UserResponse,
    val token: String,
)

data class UserResponse(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
)