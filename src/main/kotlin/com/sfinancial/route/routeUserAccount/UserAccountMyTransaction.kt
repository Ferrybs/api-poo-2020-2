package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.UserPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.myTransaction(dbInterface: DBInterface) {
    authenticate {
        get("/my-user-account/my-transaction") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val get = call.receive<Transaction>()
                val transaction = UserPermission(dbInterface).getTransaction(principal, get)
                call.respond(HttpStatusCode.Found, transaction)
            } catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}