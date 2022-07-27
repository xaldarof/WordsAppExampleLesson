package com.example.quizapp.domain.model.auth

/**
 * @Author: Temur
 * @Date: 27/07/2022
 */

data class UserLoginRequest(
    val email: String,
    val password: String,
)