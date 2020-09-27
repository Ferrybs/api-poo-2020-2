package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.conta.Conta
import br.com.empresa.financeiro.endereco.Endereco
import br.com.empresa.financeiro.pessoa.Pessoa
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
            post("/financeiro/conta/criar"){
                val nova = call.receive<Conta>()
                financeiro.cConta(nova)
                call.respond("Exito!")
            }

            // GET
            get("/$REST_INICIO") {
                call.respondText("<h1>Servidor base pronto!</h1>", ContentType.Text.Html)
            }
            get("/$REST_INICIO/conta/busca/todas") {
                val contas = financeiro.rConta()
                if(contas.isNotEmpty()) call.respond(contas)

                call.respondText("Nenhuma conta encontrada")
            }
            get("/$REST_INICIO/conta/busca/pessoa") {
                val busca = call.receive<Pessoa>()
                val res = financeiro.rConta(busca)
                call.respond("ENTREI")
                if (res != null){
                    call.respond(res)
                }
                else
                {
                    call.respondText("Nenhuma conta encontrada")
                }
            }
            get("/$REST_INICIO/conta/busca/endereco") {
                val busca = call.receive<Endereco>()
                val res = financeiro.rConta(busca)

                if (res != null){
                    call.respond(res)
                }
                else
                {
                    call.respondText("Nenhuma conta encontrada")
                }
            }
            get("/$REST_INICIO/conta/busca/endereco") {
                val busca = call.receive<Cartao>()
                val res = financeiro.rConta(busca)
                if (res != null){
                    call.respond(res)
                }
                else
                {
                    call.respondText("Nenhuma conta encontrada")
                }
            }
        }
    }.start(wait = true)

}