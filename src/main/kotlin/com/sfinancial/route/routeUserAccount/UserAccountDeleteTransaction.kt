package com.sfinancial.route.routeUserAccount

import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageDeleted
import com.sfinancial.permission.UserPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.deleteTransaction(dbInterface: DBInterface){
    authenticate {
        delete ("/my-user-account/delete-transaction") {
            try {
                val userLogin = call.principal<UserLogin>() ?: error("No principal")
                val delete = call.receive<Transaction>()
                UserPermission(dbInterface).deleteTransaction(userLogin, delete)
                throw StatusPageDeleted("Transaction deleted")
            }catch (e: StatusPageDeleted){
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}