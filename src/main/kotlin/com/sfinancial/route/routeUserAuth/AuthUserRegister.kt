package com.sfinancial.route.routeUserAuth


import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedVerifierException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.exception.InvalidRequestException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.register(dbInterface: DBInterface) {
    post("/register") {
        val user = call.receiveOrNull<User>()
        if(user != null){
            try {
                UserPermission(dbInterface).createAccount(user)
                throw StatusPageCreated("User account successfully created!")
            }catch (e: FailedVerifierException) {
                throw e
            }catch (e: Exception){
                throw InvalidFieldsException("Invalid fields! Message: ${e.message}")
            }
        }
        throw InvalidRequestException("User cannot be null!")
    }
}
