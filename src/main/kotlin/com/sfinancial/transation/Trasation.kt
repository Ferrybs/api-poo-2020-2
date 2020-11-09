package com.sfinancial.transation

open class Trasation(
        var idTransacao: String?= null,
        var data: String? = null,
        var valor: Double? = null,
        var local: String? = null,
) {
    fun verifier(): Boolean{
        val nulo = listOf(
                idTransacao,
                data,
                valor,
                local
        ).any { it == null }

        return !nulo
    }
}