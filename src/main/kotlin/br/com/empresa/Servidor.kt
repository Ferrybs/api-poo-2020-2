package br.com.empresa

import br.com.empresa.financeiro.cartao.Cartao
import br.com.empresa.financeiro.conta.Conta
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
            post("/financeiro/criarConta"){
                val nova = call.receive<Conta>()
                financeiro.cConta(nova)
                call.respond("Exito!")
            }
            post("/financeiro/buscarConta"){
                val busca = call.receive<Any>()
                var res: Any? = null
                when (busca) {
                    is Pessoa -> {
                        res = financeiro.rConta(busca)
                    }
                    is Cartao -> {
                        res = financeiro.rConta(busca)
                    }
                }
                if(res != null){
                    call.respond(res)
                }
                else
                    call.respond("Erro!")


            }

            // GET
            get("/") {
                call.respondText("<h1>Servidor base pronto!</h1>", ContentType.Text.Html)
            }
            get("/financeiro/contas") {
                val contas = financeiro.rConta()
                if(contas.isNotEmpty()) call.respond(contas)

                call.respondText("Nenhuma conta encontrada")

            }
        }
    }.start(wait = true)

}