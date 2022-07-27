package com.example.quizapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.quizapp.common.str
import com.example.quizapp.databinding.LoginFragmentLayoutBinding
import com.example.quizapp.domain.model.auth.UserLoginRequest
import com.example.quizapp.domain.respositories.AuthRepository
import kotlinx.coroutines.launch

/**
 * @Author: Temur
 * @Date: 12/07/2022
 */

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentLayoutBinding
    private lateinit var authRepository: AuthRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = LoginFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authRepository = AuthRepository()
        initActions()
    }

    private fun initActions() {
        binding.registerTv.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }

        binding.loginBtn.setOnClickListener {
            lifecycleScope.launch {
                authRepository.login(UserLoginRequest(binding.emailEdt.str,
                    binding.passwordEdt.str))
            }
        }
    }
}