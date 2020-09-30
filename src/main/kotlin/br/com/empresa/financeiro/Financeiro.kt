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
        /*
        Verifica que a conta passada por parametro nao esta nula
        e verifica se a conta tem todos o atributos preenchidos
        retorna SUCESSO se for criada e FRACASSO caso contrario
         */
        if (conta != null && conta.verificaConta()) {
            contas.add(conta)
            return "SUCESSO"
        }
        return "FRACASSO"
    }

    fun cTransacao(cartaoTransacao: CartaoTransacao?): String{
        if (verificaFinanceiro()){

            val cartao = cartaoTransacao?.cartao
            val transacao = cartaoTransacao?.transacao

            if(cartao?.verificaCartao() != null && transacao?.verificaTransacao() != null) {

                val conta = rConta(cartao)

                if(conta?.verificaConta() != null) {
                    conta.rContaCartao()?.cTransacao(transacao)
                    return "SUCESSO"
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
                    return contas.find {
                            Conta -> Conta.rContaPessoa()?.documentoPessoa == documento }
                }
                if (nome != null){
                    return contas.find { Conta -> Conta.rContaPessoa()?.nomePessoa == nome }

                }

            }
        }
        return null
    }
    fun rConta(cartao: Cartao?): Conta? {
        if (verificaFinanceiro()) {
            if (cartao != null && cartao.verificaCartao()) {
                return contas.find { Conta -> Conta.rContaCartao() == cartao }
            }
        }
        return null
    }
    fun rConta(conta: Conta?): Conta? {
        if (verificaFinanceiro()) {
            if (conta?.idConta != null) {
                return contas.find { Conta -> Conta.idConta == conta.idConta }
            }
        }
        return null
    }
    fun rTransacao(cartaoTransacao: CartaoTransacao?): MutableList<Transacao>?{
        if(verificaFinanceiro() && cartaoTransacao != null) {

            val cartao = cartaoTransacao.cartao
            val transacao = cartaoTransacao.transacao

            if(cartao?.verificaCartao() != null){
                val cartaoConta = rConta(cartao)?.rContaCartao()
                if (cartaoConta?.verificaCartao() != null) {
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
        if(verificaFinanceiro() && conta != null) {
            val busca = rConta(conta)
            if (busca != null)
            {
                val buscaCliente = busca.rContaPessoa()
                buscaCliente?.uPessoa(conta.rContaPessoa())
                return "SUCESSO"
            }
        }
        return "FRACASSO"
    }
    fun uCartao(conta: Conta?): String{
        if (verificaFinanceiro() && conta != null) {
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
        return "FRACASSO"
    }
    fun uTransacao(cartaoTransacao: CartaoTransacao?): String{

        if(verificaFinanceiro() && cartaoTransacao!=null) {
            val cartao = cartaoTransacao.cartao
            val transacao = cartaoTransacao.transacao
            if(cartao != null && cartao.verificaCartao()){
                val conta = rConta(cartao)
                if (conta != null){
                    val buscaTransacao = conta.rContaCartao()?.rTransacao(transacao)
                        if (buscaTransacao?.isNotEmpty() != null){
                            buscaTransacao[0].uTransacao(transacao)
                            return "SUCESSO"
                        }
                }
            }
        }
        return "FRACASSO"
    }
    /*
    *   DELETE
    * */
    fun dConta(conta: Conta?):String{
        if (verificaFinanceiro() && conta?.idConta != null) {
            val busca = rConta(conta)
            if (busca!=null){
                contas.remove(busca)
                return "SUCESSO"
            }
        }
        return "FRACASSO"
    }
    fun dTransacao(cartaoTransacao: CartaoTransacao?): String{
        if (verificaFinanceiro() && cartaoTransacao !=null){
            val cartao = cartaoTransacao.cartao
            val transacao = cartaoTransacao.transacao
            if (cartao?.verificaCartao() != null){
                val busca = rConta(cartao)?.rContaCartao()
                if (busca?.verificaCartao() !=null){

                    return busca.dTransacao(transacao)
                }

            }
        }
        return "FRACASSO"
    }
    private fun verificaFinanceiro(): Boolean {
        return contas.isNotEmpty()
    }

}
