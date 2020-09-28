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

    fun verificaEndereco(): Boolean {
        val nulo = listOf(
            ruaEndereco,
            numeroEndereco,
            cepEndereco,
            cidadeEndereco,
            estadoEndereco
        ).any { it == null }

        return !nulo
    }
    fun uEdereco(endereco: Endereco?){
        if(endereco != null){
            if (endereco.ruaEndereco!= null) ruaEndereco = endereco.ruaEndereco
            if (endereco.numeroEndereco!= null) numeroEndereco = endereco.numeroEndereco
            if (endereco.complementoEndereco!= null) complementoEndereco = endereco.complementoEndereco
            if (endereco.cepEndereco!= null) cepEndereco = endereco.cepEndereco
            if (endereco.cidadeEndereco!= null) cidadeEndereco = endereco.cidadeEndereco
            if (endereco.estadoEndereco!= null) estadoEndereco = endereco.estadoEndereco
        }
    }
}