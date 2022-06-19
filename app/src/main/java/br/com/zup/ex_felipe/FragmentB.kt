package br.com.zup.ex_felipe

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.ex_felipe.databinding.FragmentABinding
import br.com.zup.ex_felipe.databinding.FragmentBBinding
import kotlinx.parcelize.Parcelize


class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBBinding.inflate(inflater, container, false)
        val args = FragmentBArgs.fromBundle(requireArguments())

        binding.tvSegundoTextoB.text =
            """${args.exemploInteiro} -- ${args.booleanExemplo}"""
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Fragmento B"


        binding.btnbotao1B.setOnClickListener {
            try {
                val args1 = binding.et1B.text.toString()
                val args2 = binding.et2B.text.toString()
                val action = FragmentBDirections.actionFragmentBToFragmentA(args1, args2)
                findNavController().navigate(action)
            } catch (e: Exception) {
                binding.et1B.error = "Preencha esse campo com texto"
                binding.et2B.error = "Preencha esse campo com texto"
            }
        }

        binding.btnbotao2B.setOnClickListener {
            try {
                val args1 = binding.et1B.text.toString().toDouble()
                val args2 = binding.et2B.text.toString().toDouble()
                val action =
                    FragmentBDirections.actionFragmentBToFragmentC(Parametros(args1, args2))
                findNavController().navigate(action)
            } catch (e: Exception) {
                binding.et1B.error = "preencha esse campo com um Double"
                binding.et2B.error = "preencha esse campo com um Double"
            }
        }
    }
}

@Parcelize
data class ParametrosB(val numero1: Double, val numero2: Double) : Parcelable
