package com.sfinancial.route.routeUserAuth

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.login.LoginUser
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.routing.*


internal fun Route.login(DbInterface: DBInterface,authInterface: AuthInterface) {
    get("/login") {
        val get = call.receiveOrNull<LoginUser>()
        if (get != null){

        }
    }
}
