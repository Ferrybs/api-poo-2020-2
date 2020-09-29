package br.com.empresa.financeiro.cartao

import br.com.empresa.financeiro.transacao.Transacao
import com.google.gson.annotations.Expose

data class Cartao(
    @Expose
    var nomeCartao: String? = null,
    @Expose
    var numeroCartao: String? = null,
    @Expose
    var cidCartao: String? = null,
    @Expose
    var valCartao: String? = null,
    @Expose
    var sinceCartao: String? = null
) {

    private var transacaoCartao = mutableListOf<Transacao>()


    fun cTransacao(transacao: Transacao?){

        if(transacao != null && transacao.verificaTransacao()){
            transacaoCartao.add(transacao)
        }
    }
    fun rTransacao(): MutableList<Transacao> {
            return transacaoCartao

    }
    fun rTransacao(transacao: Transacao?): Transacao? {
        if (transacao?.idTransacao != null){
            val busca = transacaoCartao.filter {
                    Transacao -> Transacao.idTransacao == transacao.idTransacao }
            if (busca.isNotEmpty()) return busca.first()
        }

        return null

    }
    fun uCartao(cartao: Cartao?){
        if (cartao!=null){
            if (cartao.nomeCartao !=null) nomeCartao = cartao.nomeCartao
            if (cartao.numeroCartao !=null) numeroCartao = cartao.numeroCartao
            if (cartao.cidCartao !=null) cidCartao = cartao.cidCartao
            if (cartao.valCartao !=null) valCartao = cartao.valCartao
            if (cartao.sinceCartao !=null) sinceCartao = cartao.sinceCartao
        }
    }
    fun verificaCartao(): Boolean {
        val nulo = listOf(
            nomeCartao,
            numeroCartao,
            cidCartao,
            valCartao,
            sinceCartao
        ).any { it == null }

        return !nulo
    }
}