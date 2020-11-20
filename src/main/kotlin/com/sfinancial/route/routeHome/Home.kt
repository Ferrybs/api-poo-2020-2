package com.sfinancial.route.routeHome

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.html.body
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.title

internal fun Route.home(){
    get("/") {
        call.respondHtml {
            head {
                title { +"sFinancial" }
            }
            body {
                p {
                    +"Hello from Ktor Google Appengine Standard sample application"
                }
            }
        }
    }
}