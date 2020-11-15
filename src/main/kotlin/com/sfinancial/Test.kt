package com.sfinancial

import com.sfinancial.config.nettyConfig.EnvNettyConfig
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*



fun main() {
    val nettyConfig = EnvNettyConfig().getPort()
    println("++++++++++++++++++++")
    println("+ LENDO: $nettyConfig+")
    println("++++++++++++++++++++")
    embeddedServer(Netty,port = nettyConfig){
        routing {
            get(""){
                call.respond(HttpStatusCode.Accepted,"FUNCIONA")
            }
        }
    }
}