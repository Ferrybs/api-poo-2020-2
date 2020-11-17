package com.sfinancial.route.routeUserAccount

import com.sfinancial.database.DBInterface
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.notification.statusPages.StatusPageUpdated
import com.sfinancial.permission.UserPermission
import com.sfinancial.person.Person
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import io.ktor.routing.*

internal fun Route.updatePerson(dbInterface: DBInterface) {
    authenticate {
        put("/my-user-account/update-person") {
            val userLogin = call.principal<UserLogin>() ?: error("No principal")
            try {
                val put = call.receive<Person>()
                UserPermission(dbInterface).updatePerson(userLogin, put)
                throw StatusPageUpdated("Person updated!")
            } catch (e: StatusPageUpdated) {
                throw e
            } catch (e: Exception) {
                throw InvalidFieldsException("${e.message}")
            }
        }
    }
}