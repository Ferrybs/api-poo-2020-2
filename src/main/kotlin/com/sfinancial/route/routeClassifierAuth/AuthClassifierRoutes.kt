package com.sfinancial.route.routeUserAuth

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authClassifierRoutes(
        authInterface: AuthInterface,
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    routing {
        classifierLogin(authInterface,dbInterface)
    }
}
