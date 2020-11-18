package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.call.CallUserAccountTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.ClassifierPermission
import com.sfinancial.permission.FinancialPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.financialGetCreditCard(dbInterface: DBInterface) {
    authenticate {
        get("/financial/get-credit-card") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val get = call.receive<CreditCard>()
                val creditCard = FinancialPermission(dbInterface).getCreditCard(principal,get)
                call.respond(HttpStatusCode.Found, creditCard)
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
    authenticate {
        get("/financial/get-credit-card/{creditCard}") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val parameter = call.parameters["creditCard"]
                val get = CreditCard(number = parameter)
                val creditCard = FinancialPermission(dbInterface).getCreditCard(principal,get)
                call.respond(HttpStatusCode.Found, creditCard)
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}