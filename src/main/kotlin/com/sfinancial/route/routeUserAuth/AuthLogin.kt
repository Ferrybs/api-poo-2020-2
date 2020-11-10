package com.sfinancial.route.routeUserAuth

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.login(dbInterface: DBInterface,authInterface: AuthInterface) {
    get("/login") {
        val get = call.receiveOrNull<UserLogin>()
        if (get != null){
            try {
                val token = UserPermission(dbInterface).login(get,authInterface)
                call.respond(mapOf("Ok" to true,"token" to token))
            }catch (e: InvalidCredentialException){
                throw e
            } catch (e: Exception){
                throw InvalidFieldsException("Invalid Fields!")
            }
        }
    }
}
