package com.example.quizapp.domain.model

/**
 * @Author: Temur
 * @Date: 26/07/2022
 */

data class UserRegisterRequest(
    val name: String,
    val email: String,
    val password: String,
)