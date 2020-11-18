package com.sfinancial.route.routeClassifierAccont

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.category.Category
import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.ClassifierPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.classifierAddCategory(dbInterface: DBInterface,idAdminInterface: IdAdminInterface) {
    authenticate {
        post("/classifier/add-category") {
            try {
                val principal = call.principal<UserLogin>() ?: error("No principal")
                val post = call.receive<CallUserAccountCategory>()
                ClassifierPermission(dbInterface).createCategory(principal,post,idAdminInterface)
                throw StatusPageCreated("Category has been created successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}