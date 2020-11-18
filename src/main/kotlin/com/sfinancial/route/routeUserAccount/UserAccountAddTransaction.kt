package com.sfinancial.route.routeUserAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallCreditCardTransaction
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.addTransaction(dbInterface: DBInterface,idAdminInterface: IdAdminInterface){
    authenticate {
        post("/my-userAccount/add-transaction") {
            try {
                val userLogin = call.principal<Login>() ?: error("No principal")
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