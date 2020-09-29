package br.com.empresa.financeiro.conta

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.pessoa.Pessoa
import com.google.gson.annotations.Expose

data class Conta(
        @Expose
        var idConta: String? = null,
        @Expose
        private var pessoaConta: Pessoa? = null,
        @Expose
        private var limiteConta: Double? = null,
        @Expose
        private var cartaoConta: Cartao? = null
){

    // criando os metodos da classe

    fun rContaPessoa(): Pessoa? {
        return pessoaConta
    }
    fun rContaCartao(): Cartao? {
        return cartaoConta
    }

    fun uConta(conta: Conta?){
        if(conta?.idConta != null) idConta = conta.idConta
        if(conta?.limiteConta != null) limiteConta = conta.limiteConta
    }
    fun verificaConta(): Boolean{
        val nulo = listOf(
            idConta,
            limiteConta,
        ).any { it == null }

        val pessoa = pessoaConta?.verificaPessoa()
        val cartao = cartaoConta?.verificaCartao()

        if (!nulo && pessoa != null && cartao != null){
            if(cartao && pessoa){
                return true
            }
        }
        return false
    }

}