package com.sfinancial.route.routeUserAccount

import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageUpdated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.updateCategory(dbInterface: DBInterface){
    authenticate {
        put("/my-user-account/update-category") {
            try {
                val userLogin = call.principal<Login>() ?: error("No principal")
                val put = call.receive<Category>()
                UserPermission(dbInterface).updateCategory(userLogin,put)
                throw StatusPageUpdated("Category updated!")
            }catch (e :StatusPageUpdated){
                throw e
            } catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }

}