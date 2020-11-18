package com.sfinancial.route.routeUserAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.UserPermission
import com.sfinancial.transaction.Transaction
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.addTransaction(dbInterface: DBInterface,idAdminInterface: IdAdminInterface){
    authenticate {
        post("/my-userAccount/add-transaction") {
            try {
                val userLogin = call.principal<UserLogin>() ?: error("No principal")
                val post = call.receive<CallCreditCardTransaction>()
                UserPermission(dbInterface).createTransaction(userLogin,post,idAdminInterface)
                throw StatusPageCreated("Transaction created successfully!")
            }catch (e: StatusPageCreated){
                throw e
            }
            catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}