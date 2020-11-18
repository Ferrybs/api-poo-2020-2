package com.sfinancial.route.routeUserAccount

import com.sfinancial.address.Address
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.notification.statusPages.StatusPageUpdated
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
            try {
                val userLogin = call.principal<UserLogin>() ?: error("No principal")
                val put = call.receive<Address>()
                UserPermission(dbInterface).updateAddress(userLogin,put)
                throw StatusPageUpdated("Address updated!")
            }catch (e: StatusPageUpdated){
                throw e
            }
            catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}