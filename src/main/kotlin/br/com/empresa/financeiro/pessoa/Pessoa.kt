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
    private var enderecoPessoa: Endereco? = null
){
    fun rEndereco(): Endereco? {
        return enderecoPessoa
    }

    fun uPessoa(pessoa: Pessoa?){

        if (pessoa!= null){
            if(pessoa.nomePessoa != null) nomePessoa = pessoa.nomePessoa
            if(pessoa.documentoPessoa != null) documentoPessoa = pessoa.documentoPessoa
            if(pessoa.nascimentoPessoa != null) nascimentoPessoa = pessoa.nascimentoPessoa
            if(pessoa.enderecoPessoa != null) enderecoPessoa?.uEdereco(pessoa.enderecoPessoa)
        }

    }
    fun verificaPessoa() : Boolean {
        val nulo = listOf(
        documentoPessoa,
        nomePessoa,
        nascimentoPessoa
        ).any{it == null}

        val endereco = enderecoPessoa?.verificaEndereco()

        if (!nulo && endereco != null){
            return true
        }
        return false
    }
}