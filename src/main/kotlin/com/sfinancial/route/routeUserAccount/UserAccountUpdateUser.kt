package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageUpdated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.updateUser(dbInterface: DBInterface){
    authenticate {
        put("/my-user-account/update-user") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val put = call.receive<User>()
                UserPermission(dbInterface).updateUser(principal, put)
                throw StatusPageUpdated("User updated!")
            }catch (e: StatusPageUpdated){
                throw e
            }
            catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}