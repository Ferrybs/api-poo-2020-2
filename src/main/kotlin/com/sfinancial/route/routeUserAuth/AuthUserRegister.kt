package com.sfinancial.route.routeUserAuth


import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
import com.sfinancial.notification.exception.InvalidFields
import com.sfinancial.notification.exception.InvalidRequest
import com.sfinancial.notification.exception.SuccessfullyCreated
import com.sfinancial.permission.userpermission.UserPermission
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


internal fun Route.register(dbInterface: DBInterface) {
    post("/register") {
        val user = call.receiveOrNull<User>()
        if(user != null){
            try {
                UserPermission(user,dbInterface).createAccount()
                throw SuccessfullyCreated("Usuario criado com sucesso!")
            }catch (e: Exception) {
                throw InvalidFields("Campo(s) Invalido(s)! Mensagem: ${e.message}")
            }
        }
        throw InvalidRequest("User nao pode ser nulo!")
    }
}
