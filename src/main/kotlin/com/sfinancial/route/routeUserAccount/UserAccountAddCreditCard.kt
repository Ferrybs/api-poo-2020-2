package com.sfinancial.route.routeUserAccount

import com.sfinancial.config.mongoConfig.EnvMongoConfig
import com.sfinancial.database.DBInterface
import com.sfinancial.database.mongodb.ManagementMongodb
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
        post("/myUserAccount/addCreditCard") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val post = call.receiveOrNull<CreditCard>()
                if (post != null){
                    UserPermission(dbInterface).createCreditCard(userLogin,post)
                    throw StatusPageCreated("Credit card successfully added!")
                }else{
                    throw InvalidFieldsException("Invalid fields!")
                }
            }catch (e: StatusPageCreated){
                throw e
            }catch (e : Exception){
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}