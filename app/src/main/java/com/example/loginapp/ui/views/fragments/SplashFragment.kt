package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loginapp.R
import com.example.loginapp.databinding.FragmentRegisterFagmentBinding
import com.example.loginapp.databinding.FragmentSplasBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplasBinding.inflate(inflater)

        binding.btnSplash.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }


        return binding.getRoot()


    }

}