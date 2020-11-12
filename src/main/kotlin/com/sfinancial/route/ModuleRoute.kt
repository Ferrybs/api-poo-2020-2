package com.sfinancial.route

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeUserAuth.authRoutes
import com.sfinancial.route.routeHome.homeRoutes
import com.sfinancial.route.routeUserAccount.userAccountRoutes
import io.ktor.application.*


fun Application.routes(dbInterface: DBInterface,authInterface: AuthInterface) {
    userAccountRoutes(dbInterface)
    authRoutes(dbInterface,authInterface)
    homeRoutes()
}
