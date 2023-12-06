package com.example.loginapp.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loginapp.databinding.FragmentRegisterFagmentBinding

class RegisterFagment : Fragment() {

    private lateinit var binding: FragmentRegisterFagmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterFagmentBinding.inflate(inflater)
        return binding.getRoot()
    }


}