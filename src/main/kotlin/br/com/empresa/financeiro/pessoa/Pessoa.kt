package br.com.empresa.financeiro.pessoa

import br.com.empresa.financeiro.endereco.Endereco
import com.google.gson.annotations.Expose
import java.util.*

class Pessoa (
    @Expose
    var documentoPessoa: String? = null,
    @Expose
    var nomePessoa: String? = null,
    @Expose
    var nascimentoPessoa: String? = null,
    @Expose
    var enderecoPessoa: Endereco? = null
){
    fun verificaPessoa() : Boolean {
        val nulo = listOf(
        documentoPessoa,
        nomePessoa,
        nascimentoPessoa
        ).any{it == null}

        val endereco = enderecoPessoa?.verificaEndereco()

        if (endereco != null){
            return true
        }
        return false
    }
}