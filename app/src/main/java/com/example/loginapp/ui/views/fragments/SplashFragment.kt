package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.loginapp.R
import com.example.loginapp.databinding.FragmentSplasBinding
import com.example.loginapp.ui.viewmodel.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplasBinding
    private val splashViewModel: SplashViewModel by viewModel<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplasBinding.inflate(inflater)


        splashViewModel.validToken()

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        },1000)

      /*  binding.btnSplash.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }*/


        return binding.getRoot()


    }

}