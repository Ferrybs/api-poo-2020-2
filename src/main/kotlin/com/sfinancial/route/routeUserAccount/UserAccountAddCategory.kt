package com.sfinancial.route.routeUserAccount

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.addCategory(dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
    authenticate {
        post("/my-user-account/add-category") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val post = call.receive<Category>()
                UserPermission(dbInterface).createCategory(principal,post,idAdminInterface)
                throw StatusPageCreated("Category has been created successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}