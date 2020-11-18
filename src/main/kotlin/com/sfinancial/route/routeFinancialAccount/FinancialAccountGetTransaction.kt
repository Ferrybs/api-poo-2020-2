package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.call.CallUserAccountTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.ClassifierPermission
import com.sfinancial.permission.FinancialPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.financialGetTransaction(dbInterface: DBInterface) {
    authenticate {
        get("/financial/get-transaction") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val get = call.receive<Transaction>()
                val list = FinancialPermission(dbInterface).getTransaction(principal, get)
                call.respond(HttpStatusCode.Found, list)
                throw StatusPageCreated("Transaction  successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}