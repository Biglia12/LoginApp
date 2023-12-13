package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loginapp.R
import com.example.loginapp.databinding.FragmentLoginBinding
import com.example.loginapp.ui.viewmodel.LoginViewModel
import com.example.loginapp.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var  binding: FragmentLoginBinding
    private val loginViewModel by viewModel<LoginViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)

        binding.textRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

       binding.buttonLogin.setOnClickListener {

           val user: String = binding.editTextUser.text.toString()
           val pass: String = binding.editTextPass.text.toString()

           if (user.isNotEmpty() || pass.isNotEmpty()){
               loginViewModel.
           }else{
               requireContext().toast("Campos vacios")
           }

           findNavController().navigate(R.id.homeFragment)
       }

        return binding.getRoot()
    }

}