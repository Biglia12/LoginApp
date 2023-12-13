package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
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
               loginViewModel.callServiceLogin(user, pass)
           }else{
               requireContext().toast("Campos vacios")
           }

       }

        obserVer()

        return binding.getRoot()
    }

    fun obserVer(){

        loginViewModel.progressBar.observe(viewLifecycleOwner){
            binding.loaderContainer.isVisible = it
        }

        loginViewModel.errorService.observe(viewLifecycleOwner){
            context?.toast(resources.getString(R.string.error_service))
        }

        // Observa la propiedad userLogued
        loginViewModel.userLogued.observe(viewLifecycleOwner, Observer { userLogued ->
            // Navega a homeFragment si el usuario ha iniciado sesión
            if (userLogued) {
                findNavController().navigate(R.id.homeFragment)
            } else{
                context?.toast(resources.getString(R.string.error_user))
            }
        })


    }

}