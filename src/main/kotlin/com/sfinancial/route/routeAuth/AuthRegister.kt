package com.sfinancial.route.routeAuth


import com.sfinancial.admin.adminUser.AdminUserAccount
import com.sfinancial.database.DBInterface
import com.sfinancial.group.User
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

                UserPermission(user, dbInterface = dbInterface).registerAccount()
            }catch (e: Exception) {
                call.respond(HttpStatusCode.NotAcceptable)
            }
        }

    }
}
