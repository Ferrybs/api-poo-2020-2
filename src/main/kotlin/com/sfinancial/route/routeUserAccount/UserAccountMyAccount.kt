package com.sfinancial.route.routeUserAccount

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.myUserAccount(){
    get("/myUserAccount") {
        call.respond("My UserAccount Funcionando!")
    }

}