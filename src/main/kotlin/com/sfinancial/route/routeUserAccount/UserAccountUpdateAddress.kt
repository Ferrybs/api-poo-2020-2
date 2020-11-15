package com.sfinancial.route.routeUserAccount

import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

internal fun Route.updateAddress(dbInterface: DBInterface){
    authenticate {
        put ("/my-user-account/update-address") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val put = call.receive<Address>()
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}