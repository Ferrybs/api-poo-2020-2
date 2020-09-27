package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.pessoa.Pessoa
import br.com.empresa.financeiro.conta.Conta
import br.com.empresa.financeiro.transacao.Transacao


class Financeiro {
    private var contas = mutableListOf<Conta>()
    fun cConta(conta: Conta?): String {
        if (conta != null && conta.verificaConta()) {
            contas.add(conta)
            return "VALIDO"
        }
        return "INVÁLIDO"
    }

    fun rConta(pessoa: Pessoa?): Conta? {
        if (pessoa != null) {
            if (pessoa.verificaPessoa()) {
                return contas.first { Conta -> Conta.pessoaConta == pessoa }
            } else {
                val documento = pessoa.documentoPessoa
                val nome = pessoa.nomePessoa
                val endereco = pessoa.enderecoPessoa
                if (documento != null) return contas.first { Conta -> Conta.pessoaConta.documentoPessoa == documento }
                if (nome != null) return contas.first { Conta -> Conta.pessoaConta.nomePessoa == nome }
                if (endereco != null) return contas.first { Contas -> Contas.pessoaConta.enderecoPessoa == endereco }
            }
        }
        return null
    }

    fun cTransacao(lista: List<Any>?): String{

        if(lista !=null && lista.isNotEmpty()){

            if (lista[0] is Cartao && lista[1] is Transacao){
                val cartao = lista[0] as Cartao
                val transacao = lista[1] as Transacao

                // pessquisa conta com esse cartao
                val conta: Conta
                if(conta.verificaConta()){
                    conta.contaCartao?.cTransacao(transacao)
                    return "VALIDA"
                }
            }
        }

    }
}
