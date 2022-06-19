package br.com.zup.ex_felipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Aluno(
    private var nome: String,
    private var sobrenome: String
) : Parcelable {
    fun getNome() = this.nome
    fun getSobrenome() = this.sobrenome
}



