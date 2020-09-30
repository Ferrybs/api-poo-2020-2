package br.com.empresa

import br.com.empresa.financeiro.Financeiro
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
import io.ktor.utils.io.errors.*
import java.lang.reflect.Modifier

const val REST_INICIO = "/financeiro"
val financeiro = Financeiro()

suspend inline fun <reified T> ApplicationCall.safeReceive(): T? {
    val json = this.receiveOrNull<String>()
    return try {
        Gson().fromJson(json, T::class.java)
    }catch (e: IOException){
        null
    }
}




fun main() {

    embeddedServer(Netty, 8080  ) {
        routing {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting().excludeFieldsWithModifiers(
                        Modifier.STATIC,
                        Modifier.TRANSIENT,
                        Modifier.VOLATILE)
                }
            }
            //POST
            post("$REST_INICIO/criar/conta"){
                val nova = call.receiveOrNull<Conta>()
                call.respond(financeiro.cConta(nova))

            }
            post("$REST_INICIO/criar/transacao"){
                val cartaoTransacao = call.receiveOrNull<CartaoTransacao>()

                call.respond(financeiro.cTransacao(cartaoTransacao))

            }
            // GET
            get("/") {
                call.respondText("<h1>Bem Vindo(a)!</h1>", ContentType.Text.Html)
            }
            get("$REST_INICIO/buscar/todas-contas") {
                val contas = financeiro.rConta()
                if(contas?.isNotEmpty() != null) call.respond(contas)

                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/buscar/conta") {
                val busca = call.receiveOrNull<Conta>()
                val res = financeiro.rConta(busca)
                if(res != null){
                        call.respond(res)
                }
                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/buscar/conta/{idConta}") {
                val busca = call.parameters["idConta"]
                if (busca != null) {
                    val conta = Conta(busca)
                    val res = financeiro.rConta(conta)
                    if (res != null) {
                        call.respond(res)
                    }
                }
                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/buscar/pessoa") {
                val busca = call.receiveOrNull<Pessoa>()
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                else{
                    call.respondText("Nenhuma conta encontrada")
                }
            }
            get("$REST_INICIO/buscar/cartao") {
                val busca = call.receiveOrNull<Cartao>()
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                call.respondText("Nenhuma conta encontrada")
            }
            get("$REST_INICIO/buscar/transacao") {
                val busca = call.receiveOrNull<CartaoTransacao>()
                val res = financeiro.rTransacao(busca)
                if (res?.isNotEmpty() != null){
                    call.respond(res)
                }
                call.respondText("Nenhuma transacao encontrada")
            }
            // PUT
            put("$REST_INICIO/atualizar/pessoa"){
                val conta = call.receiveOrNull<Conta>()
                if (conta != null){
                    call.respond(financeiro.uPessoa(conta))
                }
                call.respond("FRACASSO")
            }
            // ###EM FAZE DE TESTES NAO FUNCIONA 100%###
            put("$REST_INICIO/atualizar/conta"){
                val lista = call.safeReceive<Array<Conta>>()
                if (lista?.isNotEmpty() !=null){
                    call.respond(financeiro.uConta(lista))
                }
                call.respond("FRACASSO")
            }
            put("$REST_INICIO/atualizar/cartao"){
                val conta = call.receiveOrNull<Conta>()
                if (conta != null){
                    call.respond(financeiro.uCartao(conta))
                }
                call.respond("FRACASSO")
            }
            put("$REST_INICIO/atualizar/transacao"){
                val cartaoTransacao = call.receiveOrNull<CartaoTransacao>()
                if (cartaoTransacao != null){
                    call.respond(financeiro.uTransacao(cartaoTransacao))
                }
                call.respond("FRACASSO")
            }
            //DELETE
            delete("$REST_INICIO/deletar/conta"){
                val conta = call.receiveOrNull<Conta>()
                if (conta != null){
                    call.respond(financeiro.dConta(conta))
                }
                call.respond("FRACASSO")
            }
            delete("$REST_INICIO/deletar/transacao"){
                val cartaoTransacao = call.receiveOrNull<CartaoTransacao>()
                if (cartaoTransacao != null){
                    call.respond(financeiro.dTransacao(cartaoTransacao))
                }
                call.respond("FRACASSO")
            }
        }

    }.start(wait = true)

}