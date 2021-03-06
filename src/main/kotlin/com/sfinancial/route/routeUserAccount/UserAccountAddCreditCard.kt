package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.payment.card.CreditCard
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.addCreditCard(dbInterface: DBInterface) {
    authenticate {
        post("/my-user-account/add-credit-card") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val post = call.receive<CreditCard>()
                    UserPermission(dbInterface).createCreditCard(principal,post)
                    throw StatusPageCreated("Credit card successfully added!")
            }catch (e: StatusPageCreated){
                throw e
            }catch (e : Exception){
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}