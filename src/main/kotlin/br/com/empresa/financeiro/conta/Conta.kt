package br.com.empresa.financeiro.conta

import br.com.empresa.financeiro.cartao.CartaoTransacao
import br.com.empresa.financeiro.pessoa.Pessoa

data class Conta(
        var idConta: String? = null,
        var pessoaConta: Pessoa? = null,
        var limiteConta: Double? = null
){
    var contaCartaoTransacao: CartaoTransacao? = null

    private var criada = false
    // conta já criada
    private var restrita = true
    // algum campo nulo


    // criando os metodos da classe
    fun cConta(){
        if(criada==false){
          idConta=(100000..999999).shuffled().first().toString()
            // if (verificaPessoa&&limeteConta!=null)
            // contaCartaotransacao
            val novo=CartaoTransacao()
           // novo.cCartaoTransacao(pessoaConta.nome)

        }
    }

    fun validaConta (): Boolean{
//        if (conta==null){
//            return false
//        }
//        else {
//            val nulo = listOf(limiteConta,idConta).any{it==null} // lista criada, perguntando se algum desses eh igual a nulo
//            if(pessoaConta.)
//
//        }
        return false
    }


}