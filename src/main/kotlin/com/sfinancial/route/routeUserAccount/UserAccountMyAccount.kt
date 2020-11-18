package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.myUserAccount(dbInterface: DBInterface){
    authenticate {
        get("/my-user-account") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val user = UserPermission(dbInterface).getUserAccount(principal)
                call.respond(HttpStatusCode.Found,user)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}