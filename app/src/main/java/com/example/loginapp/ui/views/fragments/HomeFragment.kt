package com.example.loginapp.ui.views.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.loginapp.databinding.FragmentHomeBinding
import com.example.loginapp.ui.viewmodel.Home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var  binding: FragmentHomeBinding
    private val homeViewModel by viewModel<HomeViewModel>()

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

   /*     viewModel.jwt.observe(viewLifecycleOwner){
            binding.tokenTest.text = it
        }*/

        homeViewModel.getJwt()

        obserVer()


        return binding.getRoot()
    }

    private fun obserVer() {
        homeViewModel.jwt.observe(viewLifecycleOwner){
            binding.tokenTest.text = it
        }
    }
}