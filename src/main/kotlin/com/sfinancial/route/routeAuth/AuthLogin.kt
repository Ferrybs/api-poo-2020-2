package com.sfinancial.route.routeAuth

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import io.ktor.routing.*


internal fun Route.login(dbInterface: DBInterface,authInterface: AuthInterface) {
    get("/login") {

    }
}
