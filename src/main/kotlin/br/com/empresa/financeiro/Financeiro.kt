package br.com.empresa

import br.com.empresa.financeiro.pessoa.Pessoa
import br.com.empresa.financeiro.conta.Conta


class Financeiro {
    private var contas = mutableListOf<Conta>()
    fun cConta(conta: Conta?): String {
        if (conta != null && conta.validaConta()) {
            conta.cConta()
            contas.add(conta)
            return "VALIDO"
        }
        return "INVÁLIDO"
    }

    fun rConta(pessoa: Pessoa?) {
        if (pessoa != null) {
            if (pessoa.verificaPessoa()) {
                return contas.first { Conta -> Conta.pessoaConta == pessoa }
            } else {
                val documento = documentoPessoa
                val nome = nomePessoa
                val endereco = enderecoPessoa
                if (documento != null) return contas.first { Conta -> Conta.pessoaConta.documentoPessoa == documento }
                if (nome != null) return contas.first { Conta -> Conta.pessoaConta.nomePessoa == nome }
                if (endereco != null) return contas.first { Contas -> Contas.pessoaConta.enderecoPessoa == endereco }
            }
        }
    }

    fun cTransacao(lista: Any?){
        val verificaLista()
    }
}