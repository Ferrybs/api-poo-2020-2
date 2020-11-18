package com.sfinancial.route.routeUserAccount

import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageDeleted
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.deleteCategory(dbInterface: DBInterface){
    authenticate {
        delete ("/my-user-account/delete-category") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val delete = call.receive<Category>()
                UserPermission(dbInterface).deleteCategory(principal,delete)
                throw StatusPageDeleted("Category deleted!")
            }catch (e: StatusPageDeleted){
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}