package br.com.empresa.financeiro.endereco

import com.google.gson.annotations.Expose

open class Endereco(
    @Expose
    var ruaEndereco: String? = null,
    @Expose
    var numeroEndereco: String? = null,
    @Expose
    var complementoEndereco: String? = null,
    @Expose
    var cepEndereco: String? = null,
    @Expose
    var cidadeEndereco: String? = null,
    @Expose
    var estadoEndereco: String? = null
) {

    fun vEndereco():Boolean{
        val nulo = listOf(
            ruaEndereco,
            numeroEndereco,
            cepEndereco,
            cidadeEndereco,
            estadoEndereco
        ).any{it == null}
        return !nulo
    }

}