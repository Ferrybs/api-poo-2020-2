package com.sfinancial.route.routeUserAccount

import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.deleteAddress(dbInterface: DBInterface){
    authenticate {
        delete ("/my-user-account/delete-address") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val delete = call.receive<Address>()
                UserPermission(dbInterface).deleteAddress(userLogin, delete)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}