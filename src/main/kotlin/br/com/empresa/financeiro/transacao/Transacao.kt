package br.com.empresa.financeiro.transacao

import com.google.gson.annotations.Expose

open class Transacao(
    @Expose
    var idTransacao: String?= null,
    @Expose
    var dataTransacao: String? = null,
    @Expose
    var valorTransacao: Double? = null,
    @Expose
    var localTransacao: String? = null,
) {
    fun uTransacao(transacao: Transacao?){
        if (transacao !=null){
            if (transacao.idTransacao != null) idTransacao = transacao.idTransacao
            if (transacao.dataTransacao != null) dataTransacao = transacao.dataTransacao
            if (transacao.valorTransacao != null) valorTransacao = transacao.valorTransacao
            if (transacao.localTransacao != null) localTransacao = transacao.localTransacao
        }
    }
    fun verificaTransacao(): Boolean{
        val nulo = listOf(
            idTransacao,
            dataTransacao,
            valorTransacao,
            localTransacao
        ).any { it == null }

        return !nulo
    }
}
