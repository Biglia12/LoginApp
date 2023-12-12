package com.example.loginapp.ui.views.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.loginapp.R
import com.example.loginapp.databinding.FragmentHomeBinding
import com.example.loginapp.databinding.FragmentLoginBinding

class HomeFragment : Fragment() {
    private lateinit var  binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Puedes agregar lógica personalizada aquí si lo deseas.
                // En este ejemplo, no hacemos nada, por lo que el botón de retroceso se ignora.
            }
        })


        return binding.getRoot()
    }
}