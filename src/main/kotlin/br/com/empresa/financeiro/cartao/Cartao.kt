package br.com.empresa.financeiro.cartao

import br.com.empresa.financeiro.transacao.Transacao
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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

    @SerializedName("transacaoCartao")
    @Expose(serialize = false, deserialize = false)
    private var transacaoCartao = mutableListOf<Transacao>()



    fun vCartao(): Boolean {
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