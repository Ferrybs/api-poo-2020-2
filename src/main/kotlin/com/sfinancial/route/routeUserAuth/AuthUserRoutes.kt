package com.sfinancial.route.routeUserAuth

import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authRoutes(
        authInterface: AuthInterface
) {
    routing {
        login(authInterface)
        register()
    }
}
