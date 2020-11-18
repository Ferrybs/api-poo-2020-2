package com.sfinancial.route.routeClassifierAccont

import com.sfinancial.account.UserAccount
import com.sfinancial.call.CallUserAccountCategory
import com.sfinancial.database.DBInterface
import com.sfinancial.login.Login
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.ClassifierPermission
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.classifierGetCategory(dbInterface: DBInterface) {
    authenticate {
        get("/classifier/get-category") {
            try {
                val principal = call.principal<Login>() ?: error("No principal")
                val get = call.receive<UserAccount>()
                val list = ClassifierPermission(dbInterface).getCategory(principal, get)
                call.respond(HttpStatusCode.Found, list)
            }catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}
