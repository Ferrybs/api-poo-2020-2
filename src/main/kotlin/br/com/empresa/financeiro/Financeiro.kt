package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.pessoa.Pessoa
import br.com.empresa.financeiro.conta.Conta
import br.com.empresa.financeiro.endereco.Endereco
import br.com.empresa.financeiro.transacao.Transacao
import com.google.gson.annotations.Expose


class Financeiro {
    @Expose
    private var contas = mutableListOf<Conta>()

    /*
    *   CREATE
    * */
    fun cConta(conta: Conta?): String {
        if (conta != null && conta.verificaConta()) {
            contas.add(conta)
            return "VALIDO"
        }
        return "INVÁLIDO"
    }

    fun cTransacao(cartao: Cartao?,transacao: Transacao?): String{
        if (verificaFinanceiro()){

            if(cartao != null && transacao != null){

                if(cartao.verificaCartao() && transacao.verificaTransacao()){
                    val conta = rConta(cartao)
                    if(conta != null && conta.verificaConta()) {
                        conta.rContaCartao()?.cTransacao(transacao)
                        return "VALIDA"
                }
                }
            }
        }
            return "INVALIDO"
    }
    /*
    *   READ
    * */
    fun rConta(): MutableList<Conta> {
        return contas
    }
    fun rConta(pessoa: Pessoa?): Conta? {
        if(verificaFinanceiro()) {
            if (pessoa != null) {
                if (pessoa.verificaPessoa()) {
                    return contas.first { Conta -> Conta.rContaPessoa() == pessoa }
                } else {
                    val documento = pessoa.documentoPessoa
                    val nome = pessoa.nomePessoa
                    if (documento != null) return contas.first { Conta -> Conta.rContaPessoa()?.documentoPessoa == documento }
                    if (nome != null) return contas.first { Conta -> Conta.rContaPessoa()?.nomePessoa == nome }
                }
            }
        }
        return null
    }
    fun rConta(cartao: Cartao?): Conta? {
        if (verificaFinanceiro()) {
            if (cartao != null && cartao.verificaCartao()) {
                return contas.first { Conta -> Conta.rContaCartao() == cartao }
            }
        }
        return null

    }

    fun rConta(endereco: Endereco?): Conta? {
        if(verificaFinanceiro()) {
            if (endereco != null && endereco.verificaEndereco())
                return contas.first { Contas -> Contas.rContaPessoa()?.rEndereco() == endereco }
        }
        return null
    }
    /*
    *   UPDATE
    * */
    fun verificaFinanceiro(): Boolean {
        return contas.isNotEmpty()
    }

}
