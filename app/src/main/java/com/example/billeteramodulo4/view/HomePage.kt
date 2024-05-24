package com.example.billeteramodulo4.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.billeteramodulo4.R
import com.example.billeteramodulo4.databinding.FragmentHomePageBinding
import com.example.billeteramodulo4.model.DatosContactoProveedor
import com.example.billeteramodulo4.view.adapter.ContactsAdapter

class HomePage : Fragment() {

    private lateinit var binding: FragmentHomePageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val root = binding.root

        initRecyclerView()

        binding.btnenviadinerohomepage.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_sendMoney)
        }

        binding.ingresadinerohomepage.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_requestMoney)
        }

        binding.profileuser.setOnClickListener {
            findNavController().navigate(R.id.action_homePage_to_profilePage)
        }
        return root
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ContactsAdapter(DatosContactoProveedor.contactoList)
    }

}

