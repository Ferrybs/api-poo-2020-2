package br.com.empresa.financeiro

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.cartao.CartaoTransacao
import br.com.empresa.financeiro.pessoa.Pessoa
import br.com.empresa.financeiro.conta.Conta
import br.com.empresa.financeiro.transacao.Transacao
import com.google.gson.annotations.Expose


class Financeiro {
    @Expose
    private var contas = mutableListOf<Conta>()

    /*
    *   CREATE
    * */
    fun cConta(conta: Conta?): String {
        if (conta != null && conta.verificaConta()) {
            contas.add(conta)
            return "SUCESSO"
        }
        return "FRACASSO"
    }

    fun cTransacao(cartao: Cartao?,transacao: Transacao?): String{
        if (verificaFinanceiro()){

            if(cartao != null && transacao != null){

                if(cartao.verificaCartao() && transacao.verificaTransacao()){
                    val conta = rConta(cartao)
                    if(conta != null && conta.verificaConta()) {
                        conta.rContaCartao()?.cTransacao(transacao)
                        return "SUCESSO"
                }
                }
            }
        }
            return "FRACASSO"
    }
    /*
    *   READ
    * */
    fun rConta(): MutableList<Conta>? {
        if (verificaFinanceiro()) return contas
        return null
    }
    fun rConta(pessoa: Pessoa?): Conta? {
        if(verificaFinanceiro()) {
            if (pessoa != null) {
                val documento = pessoa.documentoPessoa
                val nome = pessoa.nomePessoa
                if (documento != null){
                    val busca = contas.filter {
                            Conta -> Conta.rContaPessoa()?.documentoPessoa == documento }
                    if (busca.isNotEmpty()) return busca.first()
                }
                if (nome != null){
                    val busca = contas.filter { Conta -> Conta.rContaPessoa()?.nomePessoa == nome }
                    if (busca.isNotEmpty()) return busca.first()
                }

            }
        }
        return null
    }
    fun rConta(cartao: Cartao?): Conta? {
        if (verificaFinanceiro()) {
            if (cartao != null && cartao.verificaCartao()) {
                val busca = contas.filter { Conta -> Conta.rContaCartao() == cartao }
                if (busca.isNotEmpty()) return busca.first()
            }
        }
        return null
    }
    fun rConta(conta: Conta?): Conta? {
        if (verificaFinanceiro()) {
            if (conta?.idConta != null) {
                val busca =  contas.filter { Conta -> Conta.idConta == conta.idConta }
                if (busca.isNotEmpty()){
                    return busca.first()
                }
            }
        }
        return null
    }
    fun rTransacao(cartao: Cartao?): MutableList<Transacao>? {
        if (verificaFinanceiro()){
            if (cartao != null && cartao.verificaCartao()){

                val cartaoConta = rConta(cartao)?.rContaCartao()

                if (cartaoConta != null && cartaoConta.verificaCartao()){
                    return cartaoConta.rTransacao()
                }
            }
            }
        return null
        }
    fun rTransacao(cartao: Cartao?, transacao: Transacao?): Transacao? {
        if (verificaFinanceiro()){
            if (cartao != null && cartao.verificaCartao()){
                val cartaoConta = rConta(cartao)?.rContaCartao()

                if (cartaoConta != null && cartaoConta.verificaCartao()){

                    return cartaoConta.rTransacao(transacao)
                }
            }
        }
        return null
    }


    /*
    *   UPDATE
    * */
    fun uConta(lista: Array<Conta>): String{
        if (verificaFinanceiro() && lista.size == 2){

            val busca = rConta(lista[0])
            if (busca!=null){
                busca.uConta(lista[1])
                return "SUCESSO"
            }
        }
        return "FRACASSO"
    }
    fun uPessoa(conta: Conta?): String {
        if(verificaFinanceiro()){
        if (conta != null){
            val busca = rConta(conta)
            if (busca != null)
            {
                val buscaCliente = busca.rContaPessoa()
                buscaCliente?.uPessoa(conta.rContaPessoa())
                return "SUCESSO"
            }
        }
        }
        return "FRACASSO"
    }
    fun uCartao(conta: Conta?): String{
        if (verificaFinanceiro()) {
            if (conta != null) {
                var busca = rConta(conta)
                if (busca != null) {
                    val cartao = conta.rContaCartao()
                    val cartaoConta = busca.rContaCartao()
                    cartaoConta?.uCartao(cartao)
                    return "SUCESSO"
                } else {
                    busca = rConta(conta.rContaPessoa())
                    if (busca != null) {
                        val cartao = conta.rContaCartao()
                        val cartaoConta = busca.rContaCartao()
                        cartaoConta?.uCartao(cartao)
                        return "SUCESSO"
                    }
                }


            }
        }
        return "FRACASSO"
    }
    fun uTransacao(cartaoTransacao: CartaoTransacao?): String{

        if(verificaFinanceiro()){
            if(cartaoTransacao!=null){
                val cartao = cartaoTransacao.cartao
                val transacao = cartaoTransacao.transacao
                if(cartao != null && cartao.verificaCartao()){
                    val conta = rConta(cartao)
                    if (conta != null){
                        val buscaTransacao = conta.rContaCartao()?.rTransacao(transacao)
                            if (buscaTransacao !=null){
                                buscaTransacao.uTransacao(transacao)
                                return "SUCESSO"
                            }
                    }
                }
            }
        }
        return "FRACASSO"
    }

    private fun verificaFinanceiro(): Boolean {
        return contas.isNotEmpty()
    }

}
