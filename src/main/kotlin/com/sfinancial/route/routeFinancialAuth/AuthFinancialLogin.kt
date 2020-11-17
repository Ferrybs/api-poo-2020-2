package com.sfinancial.route.routeFinancialAuth
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.ClassifierLogin
import com.sfinancial.login.UserLogin
import com.sfinancial.notification.exception.InvalidCredentialException
import com.sfinancial.notification.exception.InvalidFieldsException
import com.sfinancial.permission.ClassifierPermission
import com.sfinancial.permission.UserPermission
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.financialLogin(authInterface: AuthInterface, dbInterface: DBInterface) {
    get("/financial/login") {
        try {
            val get = call.receive<ClassifierLogin>()
            val token = ClassifierPermission(dbInterface).login(get,authInterface)
            call.respond(mapOf("Ok" to true, "token" to token))
        } catch (e: InvalidCredentialException) {
            throw e
        }catch (e: Exception) {
            throw InvalidFieldsException("${e.message}")
        }
    }
}
