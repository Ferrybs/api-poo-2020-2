package com.sfinancial.route.routeUserAuth

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeAdminAuth.classifierRegister
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authAdminRoutes(
        authInterface: AuthInterface,
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    routing {
        classifierRegister(dbInterface,idAdminInterface)
    }
}
