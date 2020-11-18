package com.sfinancial.route.routeClassifierAccont

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageCreated
import com.sfinancial.permission.ClassifierPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.classifierGetCategory(dbInterface: DBInterface, idAdminInterface: IdAdminInterface) {
    authenticate {
        get("/classifier/get-category") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val get = call.receive<CallUserAccountCategory>()
                val list = ClassifierPermission(dbInterface).deleteCategory(principal, get)
                call.respond(HttpStatusCode.Found, list)
                throw StatusPageCreated("Category  successfully!")
            }catch (e: StatusPageCreated) {
                throw e
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}
