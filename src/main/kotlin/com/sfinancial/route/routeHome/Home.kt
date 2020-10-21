package com.sfinancial.route.routeHome

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.home(){
    get("/") {
        call.respond("Ok")
    }

}