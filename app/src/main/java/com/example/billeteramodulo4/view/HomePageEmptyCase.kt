package com.example.billeteramodulo4.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.billeteramodulo4.R
import com.example.billeteramodulo4.databinding.FragmentHomePageEmptyCaseBinding

class HomePageEmptyCase : Fragment() {

    private lateinit var binding: FragmentHomePageEmptyCaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomePageEmptyCaseBinding.inflate(inflater, container, false)
        val root = binding.root
        // Inflate the layout for this fragment

        binding.enviardineroemptypage.setOnClickListener {
            findNavController().navigate(R.id.action_homePageEmptyCase_to_sendMoney)
        }
        binding.ingresardineroemptypage.setOnClickListener {
            findNavController().navigate(R.id.action_homePageEmptyCase_to_requestMoney)
        }

        binding.profileuserempty.setOnClickListener {
            findNavController().navigate(R.id.action_homePageEmptyCase_to_profilePage)
        }

        binding.tvCerrarSesion.setOnClickListener {
            findNavController().navigate(R.id.action_homePageEmptyCase_to_splash)
        }

        return root
    }
}