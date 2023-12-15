package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.example.loginapp.utils.isNetworkAvailable
import com.example.loginapp.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by viewModel<LoginViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)

        listenerText()

        binding.buttonLogin.setOnClickListener {
            if (requireContext().isNetworkAvailable()) {
                val user: String = binding.edittextUser.text.toString()
                val pass: String = binding.edittextPass.text.toString()

                if (user.isNotEmpty() && pass.isNotEmpty()) {
                    loginViewModel.callServiceLogin(user, pass)
                } else {
                    showHelper(user, pass)
                    requireContext().toast("Campos vacios")
                }
                obserVer()
            }
        }

        binding.textRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        return binding.getRoot()

    }

    private fun listenerText() {
        binding.edittextUser.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Verifica si el texto está vacío y actualiza el HelperText en consecuencia
                binding.titleUser.isHelperTextEnabled = s.isNullOrEmpty()
                if (s.isNullOrEmpty()) {
                    binding.titleUser.helperText = "Campo requerido"
                }
            }
        })

        binding.edittextPass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Verifica si el texto está vacío y actualiza el HelperText en consecuencia
                binding.pasTittle.isHelperTextEnabled = s.isNullOrEmpty()
                if (s.isNullOrEmpty()) {
                    binding.pasTittle.helperText = "Campo requerido"
                }
            }
        })


    }

    private fun showHelper(user: String, pass: String) {

        if (user.isEmpty()) {
            binding.titleUser.helperText = "Campo requerido"
        } else {
            binding.pasTittle.isHelperTextEnabled = false
        }

        if (pass.isEmpty()) {
            binding.pasTittle.helperText = "Campo requerido"
        } else {
            binding.pasTittle.isHelperTextEnabled = false
        }
    }

    fun obserVer() {
        observeProgressBar()
        observeErrorService()
        observeUserLogued()
    }

    private fun observeProgressBar() {
        loginViewModel.progressBar.observe(viewLifecycleOwner) {
            binding.loaderContainer.isVisible = it
        }
    }

    private fun observeErrorService() {
        loginViewModel.errorService.observe(viewLifecycleOwner) {
            context?.toast(resources.getString(R.string.error_service))
        }
    }

    private fun observeUserLogued() {
        loginViewModel.userLogued.observe(viewLifecycleOwner) { userLogued ->
            if (userLogued) {
                findNavController().navigate(R.id.homeFragment)
            } else {
                context?.toast(resources.getString(R.string.error_user))
            }
        }
    }

}