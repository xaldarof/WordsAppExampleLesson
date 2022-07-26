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
import com.example.quizapp.databinding.LoginFragmentLayoutBinding
import kotlinx.coroutines.launch

/**
 * @Author: Temur
 * @Date: 12/07/2022
 */

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentLayoutBinding
    private val liveData = MutableLiveData<Int>()

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

        lifecycleScope.launch {
            liveData.observe(viewLifecycleOwner) {
                binding.wordsTv.text = it.toString()
            }
        }

        var count = 0
        binding.registerTv.setOnClickListener {
            count++
            liveData.value = count
//            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }
}