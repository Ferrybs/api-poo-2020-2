package com.sfinancial.route.routeUserAuth


import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.notification.exception.InvalidFields
import com.sfinancial.notification.exception.InvalidRequest
import com.sfinancial.permission.userpermission.UserPermission
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.register(dbInterface: DBInterface) {
    post("/register") {
        val user = call.receiveOrNull<User>()
        if(user != null){
            try {
                UserPermission(
                        user,
                        null,
                        dbInterface,
                ).registerAccount()
            }catch (e: Exception) {
                throw InvalidFields("Campo(s) Invalido(s)! Menssagem: ${e.message}")
            }
        }
        throw InvalidRequest("User nao pode ser nulo!")
    }
}
