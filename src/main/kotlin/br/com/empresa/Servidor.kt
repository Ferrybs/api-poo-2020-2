package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.cartao.CartaoTransacao
import br.com.empresa.financeiro.conta.Conta
import br.com.empresa.financeiro.pessoa.Pessoa
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

const val REST_INICIO = "/financeiro"
val financeiro = Financeiro()

suspend inline fun <reified T> ApplicationCall.safeReceive(): T? {
    val json = this.receiveOrNull<String>()
    if(json !=null && json.length > 7)
    {
        return Gson().fromJson(json, T::class.java)
    }
    return null
}


fun main() {

    embeddedServer(Netty, 8080) {
        routing {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }
            //POST
            post("$REST_INICIO/criar/conta"){
                val nova = call.receiveOrNull<Conta>()
                val res = financeiro.cConta(nova)
                call.respond(res)
            }
            post("$REST_INICIO/criar/transacao"){
                val cartaoTransacao = call.receiveOrNull<CartaoTransacao>()

                if (cartaoTransacao != null && cartaoTransacao.verificaCartaoTransacao())
                {
                    val cartao = cartaoTransacao.cartao
                    val transacao = cartaoTransacao.transacao
                    call.respond(financeiro.cTransacao(cartao,transacao))
                }
                call.respond("FRACASSO")
            }
            post("$REST_INICIO/atualizar/pessoa"){
                val conta = call.receiveOrNull<Conta>()
                if (conta != null){
                    call.respond(financeiro.uPessoa(conta))
                }
            }
            post("$REST_INICIO/atualizar/conta"){
                val lista = call.safeReceive<Array<Conta>>()
                if (lista != null && lista.isNotEmpty()){
                    call.respond(financeiro.uConta(lista))
                }
                call.respond("FRACASSO")
            }

            // GET
            get("/") {
                call.respondText("<h1>Bem Vindo(a)!</h1>", ContentType.Text.Html)
            }
            get("$REST_INICIO/busca/todas-contas") {
                val contas = financeiro.rConta()
                if(contas != null && contas.isNotEmpty()) call.respond(contas)

                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/busca/conta") {
                val busca = call.receiveOrNull<Conta>()
                if (busca != null){
                    val res = financeiro.rConta(busca)
                    if(res != null){
                        call.respond(res)
                    }
                }
                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/busca/pessoa") {
                val busca = call.receiveOrNull<Pessoa>()
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                else{
                    call.respondText("Nenhuma conta encontrada")
                }


            }
            get("$REST_INICIO/busca/cartao") {
                val busca = call.receiveOrNull<Cartao>()
                //call.respond("${busca.javaClass.name} e ${busca.verificaCartao()}")
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/busca/transacao") {
                val busca = call.receiveOrNull<CartaoTransacao>()
                if(busca != null){
                    val cartao = busca.cartao
                    val transacao = busca.transacao
                    if (transacao == null){
                        val res = financeiro.rTransacao(cartao)
                        if (res !=null && res.isNotEmpty() ){
                            call.respond(res)
                        }
                    }
                    val res = financeiro.rTransacao(cartao,transacao)
                    if (res !=null){
                        call.respond(res)
                    }

                }
                call.respondText("Nenhuma transacao encontrada")
            }
        }
    }.start(wait = true)

}