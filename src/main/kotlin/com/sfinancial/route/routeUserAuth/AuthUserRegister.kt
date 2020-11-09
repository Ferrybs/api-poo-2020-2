package com.sfinancial.route.routeUserAuth


import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.notification.exception.FailedVerifier
import com.sfinancial.notification.exception.InvalidFields
import com.sfinancial.notification.exception.InvalidRequest
import com.sfinancial.permission.userpermission.UserPermission
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
                UserPermission(user,dbInterface).createAccount()
                call.respond(HttpStatusCode.Created,
                        mapOf(
                                "OK" to true,
                                "message" to "User account successfully crested!"))
            }catch (e: FailedVerifier) {
                throw e
            }catch (e: Exception){
                throw InvalidFields("Invalid fields! Mensagem: ${e.message}")
            }
        }
        throw InvalidRequest("User nao pode ser nulo!")
    }
}
