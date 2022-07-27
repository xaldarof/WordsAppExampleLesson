package com.example.quizapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.quizapp.common.BaseResult
import com.example.quizapp.common.str
import com.example.quizapp.databinding.RegisterFragmentLayoutBinding
import com.example.quizapp.domain.model.UserRegisterRequest
import com.example.quizapp.domain.respositories.AuthRepository
import kotlinx.coroutines.launch

/**
 * @Author: Temur
 * @Date: 12/07/2022
 */

class RegisterFragment : Fragment() {

    private lateinit var binding: RegisterFragmentLayoutBinding
    private lateinit var authRepository: AuthRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = RegisterFragmentLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authRepository = AuthRepository()
        initActions()
    }

    private fun initActions() {
        binding.registerBtn.setOnClickListener {
            lifecycleScope.launch {
                val result = authRepository.register(UserRegisterRequest(binding.nameEdt.str,
                    binding.emailEdt.str,
                    binding.passwordEdt.str))

                if (result is BaseResult.Success) {
                    Toast.makeText(requireContext(), "Sucess", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Connection error !", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}