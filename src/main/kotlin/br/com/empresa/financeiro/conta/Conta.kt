package br.com.empresa.financeiro.conta

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.pessoa.Pessoa

data class Conta(
        var idConta: String? = null,
        var pessoaConta: Pessoa? = null,
        var limiteConta: Double? = null,
        var contaCartao: Cartao? = null
){

    // criando os metodos da classe
    fun verificaConta(): Boolean{
        val nulo = listOf(
            idConta,
            limiteConta,
        ).any { it == null }

        val pessoa = pessoaConta?.verificaPessoa()
        val cartao = contaCartao?.verificaCartao()

        if (pessoa != null && cartao != null){
            if(cartao && pessoa){
                return true
            }
        }
        return false
    }
}