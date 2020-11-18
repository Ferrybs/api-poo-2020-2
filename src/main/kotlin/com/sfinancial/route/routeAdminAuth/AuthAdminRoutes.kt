package com.sfinancial.route.routeAdminAuth

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import io.ktor.application.*
import io.ktor.routing.*

internal fun Application.authAdminRoutes(
        authInterface: AuthInterface,
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    routing {
        adminRegister(dbInterface,idAdminInterface)
        adminLogin(dbInterface,authInterface)

        classifierRegister(dbInterface,idAdminInterface)
        financialRegister(dbInterface,idAdminInterface)
    }
}
