package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.cartao.CartaoTransacao
import br.com.empresa.financeiro.conta.Conta
import br.com.empresa.financeiro.endereco.Endereco
import br.com.empresa.financeiro.pessoa.Pessoa
import br.com.empresa.financeiro.transacao.Transacao
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

fun main() {

    embeddedServer(Netty, 8080) {
        routing {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }
            //POST
            post("$REST_INICIO/conta/criar"){
                val nova = call.receive<Conta>()
                val res = financeiro.cConta(nova)
                call.respond(res)
            }
            post("$REST_INICIO/conta/cartao/transacao/criar"){
                val cartaoTransacao = call.receive<CartaoTransacao>()

                if (cartaoTransacao.verificaCartaoTransacao())
                {
                    val cartao = cartaoTransacao.cartao
                    val transacao = cartaoTransacao.transacao
                    call.respond(financeiro.cTransacao(cartao,transacao))
                }
                call.respond("INVALIDO")
            }

            // GET
            get("/") {
                call.respondText("<h1>Bem Vindo(a)!</h1>", ContentType.Text.Html)
            }
            get("/$REST_INICIO/conta/busca/todas") {
                val contas = financeiro.rConta()
                if(contas.isNotEmpty()) call.respond(contas)

                call.respondText("Nenhuma conta encontrada")
            }
            get("/$REST_INICIO/conta/busca/pessoa") {
                val busca = call.receive<Pessoa>()
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                call.respondText("Nenhuma conta encontrada")

            }
            get("/$REST_INICIO/conta/busca/cartao") {
                val busca = call.receive<Cartao>()
                //call.respond("${busca.javaClass.name} e ${busca.verificaCartao()}")
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                call.respondText("Nenhuma conta encontrada")

            }

        }
    }.start(wait = true)

}