package com.sfinancial.route

import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeAuth.authRoutes
import com.sfinancial.route.routeHome.homeRoutes
import io.ktor.application.*


fun Application.routes(dbInterface: DBInterface,authInterface: AuthInterface, configInterface: ConfigInterface) {
    authRoutes(dbInterface,authInterface,configInterface)
    homeRoutes()
}
