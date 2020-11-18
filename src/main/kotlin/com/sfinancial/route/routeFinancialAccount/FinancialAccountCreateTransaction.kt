package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.call.CallUserAccountTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.FinancialPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.financialCreateTransaction(dbInterface: DBInterface, idAdminInterface: IdAdminInterface) {
    authenticate {
        post("/financial/create-transaction") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val post = call.receive<CallUserAccountTransaction>()
                FinancialPermission(dbInterface).createTransaction(principal,post,idAdminInterface)
                throw StatusPageCreated("Transaction has been created successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}