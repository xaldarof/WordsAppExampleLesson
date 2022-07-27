package com.example.quizapp.common

/**
 * @Author: Temur
 * @Date: 27/07/2022
 */


sealed class BaseResult<T> {
    data class Success<T>(val data: T?) : BaseResult<T>()
    data class Error<T>(val message: String) : BaseResult<T>()
}