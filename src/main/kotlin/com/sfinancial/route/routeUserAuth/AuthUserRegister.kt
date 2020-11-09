package com.sfinancial.route.routeUserAuth


import com.sfinancial.database.DBInterface
import com.sfinancial.group.GroupUser
import com.sfinancial.notification.exception.ExceptionFailedVerifier
import com.sfinancial.notification.exception.ExceptionInvalidFields
import com.sfinancial.notification.exception.ExceptionInvalidRequest
import com.sfinancial.permission.userpermission.UserPermission
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.register(dbInterface: DBInterface) {
    post("/register") {
        val user = call.receiveOrNull<GroupUser>()
        if(user != null){
            try {
                UserPermission(dbInterface).createAccount(user)
                call.respond(HttpStatusCode.Created,
                        mapOf(
                                "OK" to true,
                                "message" to "User account successfully crested!"))
            }catch (e: ExceptionFailedVerifier) {
                throw e
            }catch (e: Exception){
                throw ExceptionInvalidFields("Invalid fields! Message: ${e.message}")
            }
        }
        throw ExceptionInvalidRequest("User cannot be null!")
    }
}
