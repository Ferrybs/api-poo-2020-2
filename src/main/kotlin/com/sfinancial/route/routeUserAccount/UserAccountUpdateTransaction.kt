package com.sfinancial.route.routeUserAccount

import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.updateTransaction(dbInterface: DBInterface){
    authenticate {
        put("/my-user-account/update-transaction") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val put = call.receive<Transaction>()
               UserPermission(dbInterface).updateTransaction(userLogin, put)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}