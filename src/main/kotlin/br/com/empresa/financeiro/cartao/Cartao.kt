package br.com.empresa.financeiro.cartao

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Cartao {
    private var criado: Boolean = false
    var nomeCartao: String? = null
    var numeroCartao: String? = null
    var cidCartao: String? = null
    var valCartao: String? = null
    var sinceCartao: String? = null
    var transacaoCartao: MutableList<String>? = null

    fun cCartao(cliente: String?) {
        /*
        * Cria uma cartao usando o nome do cliente como parametro
        * e muda o sinalizador de classe criado para true
        * OBS: Sinalizador evita que um cartao seja criado 2x pela mesma instancia */
        if (cliente != null && !criado) {

            val numero = listOf(
                (1000..9999).shuffled().first(),
                (1000..9999).shuffled().first(),
                (1000..9999).shuffled().first(),
                (1000..9999).shuffled().first(),
            )

            nomeCartao = cliente.toUpperCase()

            numeroCartao = ""
            for (i in numero) numeroCartao = "$i $numeroCartao"
            cidCartao = (100..999).shuffled().first().toString()

            val data = LocalDateTime.now()
            valCartao = data.monthValue.toString() + "/" + (data.year + 4).toString()

            val since = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/YYYY"))
            sinceCartao = since.toString()
        }
        criado = true
    }
}