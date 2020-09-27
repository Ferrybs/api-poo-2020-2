package br.com.empresa.financeiro.conta

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.pessoa.Pessoa

data class Conta(
        var idConta: String? = null,
        private var pessoaConta: Pessoa? = null,
        private var limiteConta: Double? = null,
        private var cartaoConta: Cartao? = null
){

    // criando os metodos da classe

    fun rContaPessoa(): Pessoa? {
        return pessoaConta
    }
    fun rContaLimite(): Double? {
        return limiteConta
    }
    fun rContaCartao(): Cartao? {
        return cartaoConta
    }

    fun verificaConta(): Boolean{
        val nulo = listOf(
            idConta,
            limiteConta,
        ).any { it == null }

        val pessoa = pessoaConta?.verificaPessoa()
        val cartao = cartaoConta?.verificaCartao()

        if (pessoa != null && cartao != null){
            if(cartao && pessoa){
                return true
            }
        }
        return false
    }

}