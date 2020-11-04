package com.sfinancial.route.routeAuth

import com.sfinancial.auth.AuthInterface
import com.sfinancial.config.ConfigInterface
import com.sfinancial.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authRoutes(
        dbInterface: DBInterface,
        authInterface: AuthInterface,
        configInterface: ConfigInterface
) {
    routing {
        login(dbInterface,authInterface)
        register(dbInterface,configInterface)
    }
}
