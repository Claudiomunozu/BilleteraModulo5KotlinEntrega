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
import com.example.billeteramodulo4.databinding.FragmentSendMoneyBinding
import com.example.billeteramodulo4.viewmodel.SendMoneyViewModel

class SendMoney : Fragment() {

    private lateinit var binding: FragmentSendMoneyBinding
    private val viewModel: SendMoneyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSendMoneyBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnEnviarDineroSendPage.setOnClickListener {

                val cantidad = etDineroSendPage.text.toString()
                val cantidadInt = cantidad.toIntOrNull()

                if (cantidadInt != null && cantidadInt > 0) {
                    viewModel.validarEmptySend(cantidadInt)
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(
                        requireContext(),
                        "Ingrese una cantidad válida",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        viewModel.validarSend.observe(viewLifecycleOwner, Observer { valido ->
            if (valido == true) {
                Toast.makeText(requireContext(), "Transacción exitosa", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_sendMoney_to_homePage)
                binding.etDineroSendPage.setText("") // Borrar el caché del EditText
            } else {
                Toast.makeText(
                    requireContext(),
                    "No se pudo realizar la transacción",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}