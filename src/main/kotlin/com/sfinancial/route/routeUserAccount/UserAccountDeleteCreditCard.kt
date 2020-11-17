package com.sfinancial.route.routeUserAccount

import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageDeleted
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.deleteCreditCard(dbInterface: DBInterface){
    authenticate {
        delete ("/my-user-account/delete-credit-card") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val delete = call.receive<CreditCard>()
                UserPermission (dbInterface).deleteCreditCard(userLogin,delete)
                throw StatusPageDeleted("Credit Card Deleted!")
            }catch (e: StatusPageDeleted){
                throw e
            }
            catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}