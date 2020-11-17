package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
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
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
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
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
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