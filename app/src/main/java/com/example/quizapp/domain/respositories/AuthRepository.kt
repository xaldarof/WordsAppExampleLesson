package com.example.quizapp.domain.respositories

import com.example.quizapp.common.BaseResult
import com.example.quizapp.data.api.ApiClient
import com.example.quizapp.data.api.ApiService
import com.example.quizapp.domain.model.UserRegisterRequest
import retrofit2.create

/**
 * @Author: Temur
 * @Date: 26/07/2022
 */

class AuthRepository {

    private val client = ApiClient().getInstance()?.create<ApiService>()

    suspend fun register(userRegisterRequest: UserRegisterRequest): BaseResult<String> {
        return try {
            var response = client?.register(userRegisterRequest)

            BaseResult.Success("Success")
        } catch (e: Exception) {
            BaseResult.Error(e.printStackTrace().toString())
        }
    }
}