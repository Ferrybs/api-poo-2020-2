package br.com.empresa.financeiro.conta

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.pessoa.Pessoa

class Conta(
        var idConta: String? = null,
        var pessoaConta: Pessoa? = null,
        var limiteConta: Double? = null,
        var contaCartao: Cartao? = null
){

    // criando os metodos da classe
    fun vConta(): Boolean{
        val nulo = listOf(
            idConta,
            limiteConta,
        ).any { it == null }

        val pessoa = pessoaConta?.vPessoa()
        val cartao = contaCartao?.vCartao()

        if (pessoa != null && cartao != null){
            if(cartao && pessoa){
                return true
            }
        }
        return false
    }
}