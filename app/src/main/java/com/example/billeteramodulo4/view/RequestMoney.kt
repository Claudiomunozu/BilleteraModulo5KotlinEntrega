package com.example.billeteramodulo4.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.billeteramodulo4.R
import com.example.billeteramodulo4.databinding.FragmentRequestMoneyBinding
import com.example.billeteramodulo4.viewmodel.RequestMoneyViewModel


class RequestMoney : Fragment() {

    private lateinit var binding: FragmentRequestMoneyBinding
    private val viewModel: RequestMoneyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRequestMoneyBinding.inflate(layoutInflater)
        val root = binding.root
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnIngresarDineroRequestMoney.setOnClickListener {
                val cantidad = etDineroRequestMoney.text.toString()
                val cantidadInt = cantidad.toIntOrNull()

                if (cantidadInt != null && cantidadInt > 0) {
                    viewModel.validarEmpty(cantidadInt)
                } else {// Maneja el caso en el que la cantidad no es un entero válido o es menor o igual a 0
                    Toast.makeText(
                        requireContext(),
                        "Ingrese una cantidad válida",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.validarRequest.observe(viewLifecycleOwner, Observer { valido ->
            if (valido == true) {
                Toast.makeText(requireContext(), "Ingreso exitoso", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_requestMoney_to_homePage)
                binding.etDineroRequestMoney.setText("") // Borrar el caché del EditText
            } else {
                Toast.makeText(requireContext(), "Ingrese una cantidad válida", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}

