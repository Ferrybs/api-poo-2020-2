package com.sfinancial.route.routeUserAccount

import com.sfinancial.address.Address
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.deleteCategory(dbInterface: DBInterface){
    authenticate {
        delete ("/my-user-account/delete-category") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val delete = call.receive<Category>()
                UserPermission(dbInterface).deleteCategory(userLogin,delete)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}