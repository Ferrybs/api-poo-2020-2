package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.myCreditCard(dbInterface: DBInterface){
    authenticate {
        get("/my-user-account/my-credit-card") {
            try {
                val userLogin = call.principal<Login>() ?: error("No principal")
                val get = call.receive<CreditCard>()
                val creditCard = UserPermission(dbInterface).getCreditCard(userLogin, get)
                call.respond(HttpStatusCode.Found,creditCard)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
    authenticate {
        get("/my-user-account/my-credit-card/{creditCard}") {
            try {
                val userLogin = call.principal<Login>() ?: error("No principal")
                val parameter = call.parameters["creditCard"]
                val get = CreditCard(number = parameter)
                val creditCard = UserPermission(dbInterface).getCreditCard(userLogin, get)
                call.respond(HttpStatusCode.Found,creditCard)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}