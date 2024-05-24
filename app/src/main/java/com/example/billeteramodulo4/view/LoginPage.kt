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
import com.example.billeteramodulo4.databinding.FragmentLoginPageBinding
import com.example.billeteramodulo4.viewmodel.LoginPageViewModel

class LoginPage : Fragment() {

    private lateinit var binding: FragmentLoginPageBinding

    private val viewModel: LoginPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.crearUnaNuevaCuentaLogin.setOnClickListener {

            findNavController().navigate(R.id.action_loginPageFragment_to_singupPageFragment)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLogin.setOnClickListener {
                val email = etEmailAddress.text.toString()
                val password = etPassword.text.toString()
                viewModel.validarCorreo(email, password)
            }
        }

        viewModel.validarUsuario.observe(viewLifecycleOwner, Observer { valido ->

            if (valido === true) {
                Toast.makeText(requireContext(), "Sesion iniciada", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginPageFragment_to_homePageEmptyCase)
                binding.etEmailAddress.setText("") // Borrar el caché del EditText
                binding.etPassword.setText("")// Borrar el caché del EditText
            } else {
                Toast.makeText(requireContext(), "Usuario no valido", Toast.LENGTH_SHORT).show()
            }
        })
    }
}