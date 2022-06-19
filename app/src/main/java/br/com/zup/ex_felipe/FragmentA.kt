package br.com.zup.ex_felipe

import android.app.Notification
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.zup.ex_felipe.databinding.FragmentABinding
import br.com.zup.ex_felipe.databinding.FragmentBBinding
import kotlinx.parcelize.Parcelize


class FragmentA : Fragment() {
    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Fragmento A"

        try {
            val args = FragmentAArgs.fromBundle(requireArguments())
            binding.tvSegundoTextoA.text =
                """${args.primeiroNumero} -- ${args.segundoNumero}"""
        } catch (e: Exception) {
            binding.tvSegundoTextoA.text = "Os argumentos vão aparecer aqui"
        }

        binding.btnbotao1A.setOnClickListener {
            try {
                val args1 = binding.et1A.text.toString().toBoolean()
                val args2 = binding.et2A.text.toString().toInt()
                val action = FragmentADirections.actionFragmentAToFragmentB(args1, args2)
                findNavController().navigate(action)
            } catch (e: Exception) {
                binding.et1A.error = "Preencha esse campo com um boolean"
                binding.et2A.error = "Preencha esse campo com um número inteiro"
            }
        }
        binding.btnbotao2A.setOnClickListener {
            try {
                val args1 = binding.et1A.text.toString().toDouble()
                val args2 = binding.et2A.text.toString().toDouble()
                val action =
                    FragmentADirections.actionFragmentAToFragmentC(Parametros(args1, args2))
                findNavController().navigate(action)
            } catch (e: Exception) {
                binding.et1A.error = "Prrencha esse campo com um Double"
                binding.et2A.error = "Prrencha esse campo com um Double"
            }
        }
    }
}

@Parcelize
data class Parametros(val primeiroNumero: Double, val segundoNumero: Double) : Parcelable








