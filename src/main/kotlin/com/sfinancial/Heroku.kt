package com.sfinancial

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title



fun main(){
    var porta = 8080
    try {
        porta = System.getenv("PORT").toInt()
    }catch (e: Exception){
        println("ABRINDO EM $porta")
    }


    embeddedServer(Netty,port = porta){

        routing {
            get("/") {
                call.respondHtml {
                    head {
                        title { +"Ktor: google-appengine-standard" }
                    }
                    body {
                        p {
                            +"Hello from Ktor Google Appengine Standard sample application"
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}