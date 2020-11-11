package com.sfinancial.route.routeUserAccount

import com.sfinancial.login.UserLogin
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.myUserAccount(){
    authenticate {
        get("/myUserAccount") {
            val principal = call.principal<UserLogin>() ?: error("No principal")

        }
    }

}