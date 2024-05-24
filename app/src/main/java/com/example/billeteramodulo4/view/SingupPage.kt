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
import com.example.billeteramodulo4.databinding.FragmentSingupPageBinding
import com.example.billeteramodulo4.viewmodel.SingupPageViewModel

class SingupPage : Fragment() {

    private lateinit var binding: FragmentSingupPageBinding

    private val viewModel: SingupPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSingupPageBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.yatienescuentasinguppage.setOnClickListener {

            findNavController().navigate(R.id.action_singupPageFragment_to_loginPageFragment)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            crearcuenta.setOnClickListener {

                val name = etNombre.text.toString()
                val lastName = etApellido.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val password2 = etPassword2.text.toString()
                viewModel.validarDatos(name, lastName, email, password, password2)
            }
        }

        viewModel.validarIngresoDatos.observe(viewLifecycleOwner, Observer { valid ->

            if (valid == true) {
                Toast.makeText(context, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_singupPageFragment_to_loginPageFragment)
                binding.etNombre.setText("") // Borrar el caché del EditText
                binding.etApellido.setText("")
                binding.etEmail.setText("")
                binding.etPassword.setText("")
                binding.etPassword2.setText("")
            } else {
                Toast.makeText(
                    context,
                    "Por favor ingrese los datos correctamente",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}

