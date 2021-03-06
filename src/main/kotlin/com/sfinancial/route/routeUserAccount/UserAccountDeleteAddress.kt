package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageDeleted
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.routing.*


internal fun Route.deleteAddress(dbInterface: DBInterface){
    authenticate {
        delete("/my-user-account/delete-address") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                UserPermission(dbInterface).deleteAddress(principal)
                throw StatusPageDeleted("Address deleted")
            }catch (e: StatusPageDeleted){
                throw e
            }
            catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}