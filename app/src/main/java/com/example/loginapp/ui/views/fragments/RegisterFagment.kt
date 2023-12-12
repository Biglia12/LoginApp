package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.loginapp.R
import com.example.loginapp.databinding.FragmentRegisterFagmentBinding
import com.example.loginapp.ui.viewmodel.RegisterViewModel
import com.example.loginapp.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFagment : Fragment() {

    private lateinit var binding: FragmentRegisterFagmentBinding

    // private val registerViewModel: RegisterViewModel by viewModel()
    private val registerViewModel by viewModel<RegisterViewModel>()
    private lateinit var user: String
    private lateinit var pass: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterFagmentBinding.inflate(inflater)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.button2.setOnClickListener {
            user = binding.editTextUser.text.toString()
            pass = binding.editTextPass.text.toString()

            registerViewModel.callServiceUser(user, pass)
        }

        obserVer()


    }

    private fun obserVer() {

        registerViewModel.progressBar.observe(viewLifecycleOwner) {
            binding.loaderContainer.isVisible = it
        }

        registerViewModel.messageResponse.observe(viewLifecycleOwner) {
            requireContext().toast(it)
            //Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }

        registerViewModel.errorService.observe(viewLifecycleOwner){
            requireContext().toast(resources.getString(R.string.error_service))
        }
    }


}