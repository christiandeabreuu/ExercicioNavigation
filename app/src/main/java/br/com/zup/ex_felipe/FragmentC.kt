package br.com.zup.ex_felipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.ex_felipe.databinding.FragmentCBinding


class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Fragmento C"

        val args = FragmentCArgs.fromBundle(requireArguments())

        binding.tvSegundoTextoC.text =
            "${args.parametros.primeiroNumero} -- ${args.parametros.segundoNumero}"



        binding.btnbotao1C.setOnClickListener {
            try {
                val args1 = binding.et1C.text.toString()
                val args2 = binding.et2C.text.toString()
                val action = FragmentCDirections.actionFragmentCToFragmentA(args1, args2)
                findNavController().navigate(action)
            } catch (e: Exception) {
                binding.et1C.error = "Preencha esse campo com texto"
                binding.et2C.error = "Preencha esse campo com texto"
            }
        }

        binding.btnbotao2C.setOnClickListener {
            try {
                val args1 = binding.et1C.text.toString().toBoolean()
                val args2 = binding.et2C.text.toString().toInt()
                val action = FragmentCDirections.actionFragmentCToFragmentB(args1, args2)
                findNavController().navigate(action)
            } catch (e: Exception) {
                binding.et1C.error = "Preencha esse campo com um boolean"
                binding.et2C.error = "Preencha esse campo com um boolean"
            }
        }
    }
}