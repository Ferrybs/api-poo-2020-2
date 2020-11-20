package com.sfinancial

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main(){
    val porta = System.getenv("PORT").toInt()

    embeddedServer(Netty,port = porta){

        routing {
            get("/") {
                call.respond("FUDEUUU")
            }
        }
    }.start(wait = true)
}