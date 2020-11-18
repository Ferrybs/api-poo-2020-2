package com.sfinancial.route.routeFinancialAccount

import com.sfinancial.call.CallCreditCardTransaction
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
import io.ktor.request.*
import io.ktor.routing.*

fun Route.financialAccountUpdateTransaction(dbInterface: DBInterface) {
    authenticate {
        put("/financial/update-transaction") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val put = call.receive<CallCreditCardTransaction>()
                FinancialPermission(dbInterface).updateTransaction(principal,put)
                throw StatusPageCreated("Transaction has been update successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}