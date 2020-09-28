package br.com.empresa.financeiro.cartao

import br.com.empresa.financeiro.transacao.Transacao
import com.google.gson.annotations.Expose

class CartaoTransacao(
    @Expose
    var cartao: Cartao?=null,
    @Expose
    var transacao: Transacao? = null
){
    fun verificaCartaoTransacao(): Boolean{
        if (cartao != null && transacao != null){
             if (cartao!!.verificaCartao() && transacao!!.verificaTransacao()) return true
        }
        return false
    }
}