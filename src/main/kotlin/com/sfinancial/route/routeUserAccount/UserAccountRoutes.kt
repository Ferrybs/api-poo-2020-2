package com.sfinancial.route.routeUserAccount

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeUserAuth.login
import com.sfinancial.route.routeUserAuth.register
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.userAccountRoutes(
        dbInterface: DBInterface
) {
    routing {
        addCreditCard(dbInterface)
        myUserAccount(dbInterface)
    }
}