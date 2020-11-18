package com.sfinancial.route.routeUserAccount

import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageUpdated
import com.sfinancial.permission.UserPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.updateTransaction(dbInterface: DBInterface){
    authenticate {
        put("/my-user-account/update-transaction") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val put = call.receive<CallCreditCardTransaction>()
               UserPermission(dbInterface).updateTransaction(principal, put)
                throw StatusPageUpdated("Transaction updated!")
            }catch (e: StatusPageUpdated){
                throw e
            }
            catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}