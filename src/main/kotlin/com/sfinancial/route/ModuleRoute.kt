package com.sfinancial.route

import com.sfinancial.admin.idAdmin.IdAdminInterface
import com.sfinancial.auth.AuthInterface
import com.sfinancial.database.DBInterface
import com.sfinancial.route.routeUserAuth.authUserRoutes
import com.sfinancial.route.routeHome.homeRoutes
import com.sfinancial.route.routeUserAccount.userAccountRoutes
import com.sfinancial.route.routeAdminAuth.authAdminRoutes
import com.sfinancial.route.routeClassifierAccont.classifierAccountRotes
import com.sfinancial.route.routeFinancialAccount.financialRoutes
import com.sfinancial.route.routeUserAuth.authClassifierRoutes
import com.sfinancial.route.routeUserAuth.authFinancialRoutes
import io.ktor.application.*


fun Application.routes(
        authInterface: AuthInterface,
        dbInterface: DBInterface,
        idAdminInterface: IdAdminInterface
) {
    userAccountRoutes(dbInterface,idAdminInterface)
    authUserRoutes(authInterface,dbInterface,idAdminInterface)

    classifierAccountRotes(dbInterface,idAdminInterface)
    authClassifierRoutes(authInterface,dbInterface,idAdminInterface)

    financialRoutes(authInterface,dbInterface,idAdminInterface)
    authFinancialRoutes(authInterface,dbInterface,idAdminInterface)

    authAdminRoutes(authInterface,dbInterface,idAdminInterface)

    homeRoutes()
}
