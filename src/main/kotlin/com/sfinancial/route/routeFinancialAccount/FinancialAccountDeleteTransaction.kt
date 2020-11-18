package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.FinancialPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.financialDeleteTransaction(dbInterface: DBInterface, idAdminInterface: IdAdminInterface) {
    authenticate {
        delete("/financial/delete-transaction") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val delete = call.receive<Transaction>()
                FinancialPermission(dbInterface).deleteTransaction(principal,delete)
                throw StatusPageCreated("Transaction has been deleted successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}