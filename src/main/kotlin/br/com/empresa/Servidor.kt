package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.conta.Conta
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

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
            post("/financeiro"){
                val nova = call.receive<Conta>()
                financeiro.cConta(nova)
                call.respond("Exito!")
            }

            // GET
            get("/") {
                call.respondText("<h1>Servidor base pronto!</h1>", ContentType.Text.Html)
            }
            get("/financeiro") {
                val contas = financeiro.rConta()
                if(contas.isNotEmpty()) call.respond(contas)

                call.respondText("Nenhuma conta encontrada")

            }
        }
    }.start(wait = true)

}