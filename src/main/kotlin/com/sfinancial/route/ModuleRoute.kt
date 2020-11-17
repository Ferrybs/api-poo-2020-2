package com.sfinancial.route

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeUserAuth.authRoutes
import com.sfinancial.route.routeHome.homeRoutes
import com.sfinancial.route.routeUserAccount.userAccountRoutes
import io.ktor.application.*


fun Application.routes(
        authInterface: AuthInterface,
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    userAccountRoutes(dbInterface,idAdminInterface)
    authRoutes(authInterface,dbInterface,idAdminInterface)
    homeRoutes()
}
