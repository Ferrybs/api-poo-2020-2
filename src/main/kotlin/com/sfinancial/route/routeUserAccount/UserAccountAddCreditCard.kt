package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
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
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val post = call.receive<CreditCard>()
                    UserPermission(dbInterface).createCreditCard(userLogin,post)
                    throw StatusPageCreated("Credit card successfully added!")
            }catch (e: StatusPageCreated){
                throw e
            }catch (e : Exception){
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}